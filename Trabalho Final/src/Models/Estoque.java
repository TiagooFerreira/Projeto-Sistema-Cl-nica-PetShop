package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author tiago
 */
public class Estoque extends DAO{
    private String nome_produto;
    private double valor_produto;
    private int qtd_produto;
    
    PreparedStatement pst = null;
    ResultSet rs = null;
    ArrayList<Estoque> estoque;
    
    public Estoque(){
        estoque = new ArrayList<Estoque>();
    }
    
    public Estoque(String nome_produto, double valor_produto, int qtd_produto){
        this.nome_produto = nome_produto;
        this.valor_produto = valor_produto;
        this.qtd_produto = qtd_produto;
        estoque = new ArrayList<Estoque>();
         
    }
    
    public TableModel allId() {
        String sql = "select * from estoque";
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
    
    public TableModel all() {
        String sql = "select estoque.nome_produto, estoque.qtd_produto, estoque.valor_produto from estoque";
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
        String sql = "insert into estoque(nome_produto, valor_produto, qtd_produto) values(?, ?, ?)";
        
        try {
            this.conectar();
            pst = this.conexao.prepareStatement(sql);
            pst.setString(1, getNome_produto());
            pst.setDouble(2, getValor_produto());
            pst.setInt(3, getQtd_produto());
            pst.executeUpdate();
            System.out.println("Produto cadastrado com sucesso!");
            this.desconectar(this.conexao);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public boolean destroy(String nome_produto) {
        String sql = "delete from estoque where nome_produto=?";
        
        try {
            this.conectar();
            pst = this.conexao.prepareStatement(sql);
            pst.setString(1, nome_produto);
            pst.executeUpdate();
            System.out.println("Produto excluído com sucesso!");
            this.desconectar(this.conexao);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public TableModel findByName(String busca) {
        String sql = "select * from estoque where id_produto like ?";
        TableModel tb = null;
        
        try {
            this.conectar();
            pst = this.conexao.prepareStatement(sql);
            pst.setString(1, busca + "%");
            rs = pst.executeQuery();
            tb = DbUtils.resultSetToTableModel(rs);
            this.desconectar(this.conexao);
            return tb;
        } catch (SQLException ex) {
            System.out.println(ex);
            return tb;
        }
    }
    
    public boolean update(String nome_produto, String valor_produto, String qtd_produto, int id) {
        String sql = "update estoque set nome_produto=?, valor_produto=?, qtd_produto=? where id_produto=?";
        
        try {
            this.conectar();
            pst = this.conexao.prepareStatement(sql);
            pst.setString(1, nome_produto);
            pst.setString(2, valor_produto);
            pst.setString(3, qtd_produto);
            pst.setInt(4, id);
            pst.executeUpdate();
            System.out.println("Produto editado com sucesso!");
            this.desconectar(this.conexao);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public TableModel valorEstoque(){
         
        String sql = "select sum(valor_produto*qtd_produto) as valor_total_estoque from estoque";
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

    /**
     * @return the nome_produto
     */
    public String getNome_produto() {
        return nome_produto;
    }

    /**
     * @param nome_produto the nome_produto to set
     */
    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    /**
     * @return the valor_produto
     */
    public double getValor_produto() {
        return valor_produto;
    }

    /**
     * @param valor_produto the valor_produto to set
     */
    public void setValor_produto(double valor_produto) {
        this.valor_produto = valor_produto;
    }

    /**
     * @return the qtd_produto
     */
    public int getQtd_produto() {
        return qtd_produto;
    }

    /**
     * @param qtd_produto the qtd_produto to set
     */
    public void setQtd_produto(int qtd_produto) {
        this.qtd_produto = qtd_produto;
    }

}
