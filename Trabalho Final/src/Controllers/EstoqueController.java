
package Controllers;

import Models.Estoque;
import Models.Funcionario;
import java.util.ArrayList;
import javax.swing.table.TableModel;

/**
 *
 * @author tiago
 */
public class EstoqueController {
    
    public TableModel index() {
        return new Estoque().all();
    }
    
    public TableModel index2() {
        return new Estoque().allId();
    }
    
    public boolean create(String nome_produto, double valor_produto, int qtd_produto) {
        Estoque e = new Estoque(nome_produto, valor_produto, qtd_produto);
        return e.save();
    }
    
    public boolean delete(String Nome_produto) {
        return new Estoque().destroy(Nome_produto);
    }
    
    public TableModel findName(String busca) {
        return new Estoque().findByName(busca);
    }
    
    public boolean edit(String nome_produto, String valor_produto, String qtd_produto, int id) {
        return new Estoque().update(nome_produto,valor_produto,qtd_produto, id);
    }
    
    public TableModel valorEstoque() {
        return new Estoque().valorEstoque();
    }
    
}
