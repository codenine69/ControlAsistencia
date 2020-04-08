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
public class OcurrenciaDto {
    
    private int idOcurrencia;
    private String Descripcion;

    public OcurrenciaDto() {
    }

    public OcurrenciaDto(int idOcurrencia, String Descripcion) {
        this.idOcurrencia = idOcurrencia;
        this.Descripcion = Descripcion;
    }

    @Override
    public String toString() {
        return  Descripcion ;
    }

    
    
    public int getIdOcurrencia() {
        return idOcurrencia;
    }

    public void setIdOcurrencia(int idOcurrencia) {
        this.idOcurrencia = idOcurrencia;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
}
