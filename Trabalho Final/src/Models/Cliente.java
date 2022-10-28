package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public class Cliente extends DAO{
    private String nome, cpf, celular, endereco;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ArrayList<Cliente> clientes;
    
    public Cliente(){
        clientes = new ArrayList<Cliente>();
    }
    
    public Cliente(String nome, String cpf, String celular, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
        this.endereco = endereco;
        clientes = new ArrayList<Cliente>();
    }
    
    public TableModel all() {
        String sql = "select * from cliente";
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
    
    public TableModel all2() {
        String sql = "select cliente.nome, cliente.cpf from cliente";
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
    
    
    
    public TableModel findByName(String busca) {
        String sql = "select * from cliente where id_cliente like ?";
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
    
    public boolean save() {
        String sql = "insert into cliente(nome, cpf, endereco, celular) values(?, ?, ?, ?)";
        try {
            this.conectar();
            pst = this.conexao.prepareStatement(sql);
            pst.setString(1, getNome());
            pst.setString(2, getCpf());
            pst.setString(3, getEndereco());
            pst.setString(4, getCelular());
            pst.executeUpdate();
            System.out.println("Cliente cadastrado com sucesso!");
            this.desconectar(this.conexao);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public boolean update(String nome, String cpf, String endereco, String celular, int id) {
        String sql = "update cliente set nome=?, cpf=?, endereco=?, celular=? where id_cliente=?";
        
        try {
            this.conectar();
            pst = this.conexao.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setString(2, cpf);
            pst.setString(3, endereco);
            pst.setString(4, celular);
            pst.setInt(5, id);
            pst.executeUpdate();
            System.out.println("Cliente editado com sucesso!");
            this.desconectar(this.conexao);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public boolean destroy(String nome, String cpf) {
        String sql = "delete from cliente where nome=? and cpf=?";
        
        try {
            this.conectar();
            pst = this.conexao.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setString(2, cpf);
            pst.executeUpdate();
            System.out.println("Cliente excluído com sucesso!");
            this.desconectar(this.conexao);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }   

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
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
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
