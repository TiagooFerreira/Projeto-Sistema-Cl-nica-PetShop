package Controllers;

import Models.Funcionario;
import java.util.ArrayList;
import javax.swing.table.TableModel;
/**
 *
 * @author tiago
 */
public class FuncionarioController {
    
    public TableModel index() {
        return new Funcionario().all();
    }
    
    public boolean autentic(String login, String senha){
       return new Funcionario().logar(login, senha);
    }
    
    public boolean create(String nome, String tel, String endereco, String login, String senha) {
        Funcionario f = new Funcionario(nome, tel, endereco, login, senha);
        return f.save();
    } 
    
}
