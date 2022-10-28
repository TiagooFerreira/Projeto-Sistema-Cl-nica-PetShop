
package Controllers;

import Models.Cliente;
import java.util.ArrayList;
import javax.swing.table.TableModel;

public class ClienteController {
    
    public TableModel index() {
        return new Cliente().all();
    }
    
    public TableModel index2() {
        return new Cliente().all2();
    }
    
    public TableModel findName(String busca) {
        return new Cliente().findByName(busca);
    }
    
    public boolean create(String nome, String cpf, String endereco, String celular) {
        Cliente c = new Cliente(nome, cpf, endereco, celular);
        return c.save();
    }
    
    public boolean edit(String nome, String cpf, String endereco, String celular, int id) {
        return new Cliente().update(nome, cpf, endereco, celular ,id);
    }
    
    public boolean delete(String nome, String cpf) {
        return new Cliente().destroy(nome, cpf);
    }
}
