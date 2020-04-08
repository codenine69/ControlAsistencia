
package codenine.interfaz;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public interface DAOInterfaz  <O>{
    
    public void registrar(O o);
    public void eliminar(O o);
    public void actualizar(O o);
    public DefaultTableModel tabla();
    public DefaultComboBoxModel combo();
    
}
