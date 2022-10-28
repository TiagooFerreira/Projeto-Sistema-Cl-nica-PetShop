package Models;

import Views.ViewInicial;
import Views.ViewPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author tiago
 */
public class Funcionario extends DAO{
    
    private String nome,tel,endereco,login,senha;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ArrayList<Funcionario> funcionarios;
    
    public Funcionario(){
        funcionarios = new ArrayList<Funcionario>();
    }
    
    public Funcionario(String nome, String tel, String endereco, String login, String senha){
        this.nome = nome;
        this.tel = tel;
        this.endereco = endereco;
        this.login = login;
        this.senha = senha;
        funcionarios = new ArrayList<Funcionario>();
    }
    
    public TableModel all() {
        String sql = "select funcionario.id_funcionario, funcionario.func_nome from funcionario";
        TableModel tb = null;
        
        try {
            this.conectar();
            pst = this.conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            tb = DbUtils.resultSetToTableModel(rs);
            this.desconectar(this.conexao);
            return tb;
        } catch (SQLException ex) {
            System.out.println(ex);
            return tb;
        }
    }
 
    public boolean save() {
        String sql = "insert into funcionario(func_nome, func_tel, func_endereco, func_login, func_senha) values(?, ?, ?, ?, ?)";
        
        try {
            this.conectar();          
            pst = this.conexao.prepareStatement(sql);
            pst.setString(1, getNome());
            pst.setString(2, getTel());
            pst.setString(3, getEndereco());
            pst.setString(4, getLogin());
            pst.setString(5, getSenha());
            pst.executeUpdate();
            System.out.println("Funcionario cadastrado com sucesso!");
            this.desconectar(this.conexao);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
         
    public boolean logar(String login, String senha) {
        String sql = "select * from funcionario where func_login=? and func_senha=?";
        
        try {
            this.conectar();
            pst = this.conexao.prepareStatement(sql);
            pst.setString(1, login);
            pst.setString(2, senha);
            rs = pst.executeQuery();   
            if (rs.next()) {
                ViewPrincipal principal = new ViewPrincipal();
                principal.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Usúario ou senha incorretos!");
                ViewInicial vi = new ViewInicial();
                vi.setVisible(true);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
        
    }
    
    
    /*public void SomaProduto() throws SQLException{
        double total = 0;
        String sql = "select estoque.valor_produto, estoque.qtd_produto from estoque";
        TableModel tb = null;
        this.conectar();
        rs = pst.executeQuery(); 
            try {
                
                while(rs.next()){
                    total = total + rs.getFloat("valor_produto")*rs.getInt("qtd_produto");
                }        
                
        } catch (Exception e) {
        }
        
    }
    /*

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the usuario
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the usuario to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
}
