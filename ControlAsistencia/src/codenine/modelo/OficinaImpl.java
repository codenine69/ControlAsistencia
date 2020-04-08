/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codenine.modelo;

import codenine.dto.OficinaDTO;
import codenine.interfaz.OficinaInterfaz;
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
public class OficinaImpl implements OficinaInterfaz{

    Conexion con = new Conexion();
    Connection conn = con.ConeccionSQL();

    @Override
    public void registrar(OficinaDTO m) {
         String sql = "INSERT INTO oficina (idoficina,descripcion)values(?,?)";

        try {
            PreparedStatement stament = conn.prepareStatement(sql);
            stament.setInt(1, m.getIdOficina());
            stament.setString(2, m.getDescripcion());
            int rowsInsert = stament.executeUpdate();
            if (rowsInsert > 0) {
                System.out.println("registro de la oficina correctamente");
                JOptionPane.showMessageDialog(null, "registro de la oficina correctamente");
            }
        } catch (SQLException sqle) {
            System.out.println("Sql Exception - InsertarClase: " + sqle.getMessage());
            JOptionPane.showConfirmDialog(null, sqle.toString());
        }
    }

    @Override
    public void eliminar(OficinaDTO c) {
         String sql = "delete from oficina where idoficina=?";

        try {
            PreparedStatement stament = conn.prepareStatement(sql);
            stament.setInt(1, c.getIdOficina());

            int rowsDeleted = stament.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("se elimino una oficina correctamente");
                 JOptionPane.showMessageDialog(null, "se elimino una oficina correctamente");
            }

        } catch (SQLException sqle) {
            System.out.println("sql exception: " + sqle.getMessage());
        }
    }

    @Override
    public void actualizar(OficinaDTO c) {
        //String sql = "update Mascota set nombreMascota=?,edad=?,nombreDueño=? where mascota=?";
        String sql = "update oficina set descripcion=? where idoficina=?";

        try {
            PreparedStatement stament = conn.prepareStatement(sql);
            stament.setString(1, c.getDescripcion());
            stament.setInt(2, c.getIdOficina());

            int rowsupdated = stament.executeUpdate();
            if (rowsupdated > 0) {
                System.out.println("se Actualizo Oficina correctamente");
                 JOptionPane.showMessageDialog(null, "se Actualizo Oficina correctamente");
            }

        } catch (SQLException e) {
            System.out.println("Sql Exception: " + e.getMessage());
        }
    }

    @Override
    public DefaultTableModel tabla() {
           DefaultTableModel Modelo = new DefaultTableModel();
        Modelo.addColumn("Id");
        Modelo.addColumn("Descripcion");

        Object[] fila = new Object[Modelo.getColumnCount()];

        try {
            String sql = "select * from oficina";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                fila[0] = rs.getInt(1);
                fila[1] = rs.getString(2);;
                Modelo.addRow(fila);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return Modelo;
    }

    @Override
    public DefaultComboBoxModel combo() {
         DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        Conexion con = new Conexion();
        try {
            int b = 2;
            //  String sql = "SELECT SISUBD_C_CODI04, SISUBD_V_DESC15 FROM SISUBDIRECCION WHERE SIUU_C_CODI03="+persona.getUnidad()+"";
            String sql = "select * from oficina";
            ResultSet rs = con.getDatos(sql);
            int n = 0;
            while (rs.next()) {
//                DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
                OficinaDTO per = new OficinaDTO();
                per.setIdOficina(rs.getInt(1));
                per.setDescripcion(rs.getString(2));
                modelo.addElement(per);
//                System.out.println(per.getDescripcion());
            }
            rs.close();

//             JOptionPane.showMessageDialog(null, "oka mdaldito" );
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error personal: " + e);
        } finally {
            con.CerrarConexion();
        }
        return modelo;
    }
}
