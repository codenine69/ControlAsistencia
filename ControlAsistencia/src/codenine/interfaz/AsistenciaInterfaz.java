/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codenine.interfaz;

import codenine.dto.AsistenciaDTO;
import codenine.dto.OficinaDTO;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Francisco Ninus
 */
public interface AsistenciaInterfaz extends DAOInterfaz<AsistenciaDTO>{
    
    public DefaultTableModel tablaAsistencia(OficinaDTO oficina);
}
