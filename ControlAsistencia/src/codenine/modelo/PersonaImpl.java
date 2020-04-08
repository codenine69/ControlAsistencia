/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codenine.modelo;

import codenine.dto.PersonaDto;
import codenine.interfaz.PersonaInterfaz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Francisco Ninus
 */
public class PersonaImpl implements PersonaInterfaz{

    Conexion con = new Conexion();
    Connection conn = con.ConeccionSQL();
    
    @Override
    public void registrar(PersonaDto p) {
        String sql = "INSERT INTO persona values(?,?,?,?,?,?,?)";

        try {
            PreparedStatement stament = conn.prepareStatement(sql);
            stament.setInt(1, p.getIdPersona());
            stament.setString(2, p.getNombre());
            stament.setString(3, p.getApPaterno());
            stament.setString(4, p.getApMaterno());
            stament.setString(5, p.getSexo());
            stament.setString(6, p.getCargo());
            stament.setInt(7, p.getIdOficina());
            int rowsInsert = stament.executeUpdate();
            if (rowsInsert > 0) {
                System.out.println("Se ingreso una persona correctamente");
            }
        } catch (SQLException sqle) {
            System.out.println("Sql Exception : " + sqle.getMessage());
        }finally{
            con.CerrarConexion();
        }
    }

    @Override
    public void eliminar(PersonaDto p) {
        String sql = "delete from persona where idpersona=?";

        try {
            PreparedStatement stament = conn.prepareStatement(sql);
            stament.setInt(1, p.getIdPersona());

            int rowsDeleted = stament.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("se elimino una persona correctamente");
            }

        } catch (SQLException sqle) {
            System.out.println("sql exception: " + sqle.getMessage());
        }finally{
            con.CerrarConexion();
        }
    }

    @Override
    public void actualizar(PersonaDto p) {
      //String sql = "update Mascota set nombreMascota=?,edad=?,nombreDueño=? where mascota=?";
        String sql = "update persona set nombre=?,paterno=?,materno=?,sexo=?,cargo=?,idoficinafk=? where idpersona=?";

        try {
            PreparedStatement stament = conn.prepareStatement(sql);
            stament.setString(1, p.getNombre());
            stament.setString(2, p.getApPaterno());
            stament.setString(3, p.getApMaterno());
            stament.setString(4, p.getSexo());
            stament.setString(5, p.getCargo());
            stament.setInt(6, p.getIdOficina());
            stament.setInt(7, p.getIdPersona());

            int rowsupdated = stament.executeUpdate();
            if (rowsupdated > 0) {
                System.out.println("se Actualizo una Persona correctament");
                JOptionPane.showMessageDialog(null, "se actualizo correctamente");
            }

        } catch (SQLException e) {
            System.out.println("Sql Exception: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "error SQL actualizar: "+e);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "error actualizar: "+ex);
        }finally{
            con.CerrarConexion();
        }
    }

    @Override
    public DefaultTableModel tabla() {
         DefaultTableModel Modelo = new DefaultTableModel();
        Modelo.addColumn("id");
        Modelo.addColumn("nombre");
        Modelo.addColumn("paterno");
        Modelo.addColumn("materno");
        Modelo.addColumn("sexo");
        Modelo.addColumn("cargo");
        Modelo.addColumn("oficina");

        Object[] fila = new Object[Modelo.getColumnCount()];

        try {
            String sql = "select idpersona, nombre, paterno, materno,sexo,cargo,descripcion from persona \n"
                    + "inner join oficina on oficina.idoficina = persona.idoficinafk";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                fila[0] = rs.getInt(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = rs.getString(5);
                fila[5] = rs.getString(6);
                fila[6] = rs.getString(7);
                Modelo.addRow(fila);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            con.CerrarConexion();
        }
        return Modelo;
    }

    @Override
    public DefaultComboBoxModel combo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
