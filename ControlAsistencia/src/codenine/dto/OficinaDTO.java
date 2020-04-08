/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codenine.dto;

/**
 *
 * @author Francisco Ninus
 */
public class OficinaDTO {

    private int idOficina;
    private String Descripcion;

    public OficinaDTO() {
    }

    public OficinaDTO(int idOficina, String Descripcion) {
        this.idOficina = idOficina;
        this.Descripcion = Descripcion;
    }
    
      @Override
    public String toString() {
        return  Descripcion ;
    }


    public int getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(int idOficina) {
        this.idOficina = idOficina;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

//    @Override
//    public String toString() {
//        return "OficinaDTO{" + "idOficina=" + idOficina + ", Descripcion=" + Descripcion + '}';
//    }

}
