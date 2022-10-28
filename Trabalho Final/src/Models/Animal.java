package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public class Animal extends DAO{
    private String tipo_animal, nome_animal, raca, idade, cpf_dono_animal;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ArrayList<Animal> animais;
    
    public Animal(){
        animais = new ArrayList<Animal>();
    }
    
    public Animal(String tipo_animal, String nome_animal, String raca, String idade, String cpf_dono_animal) {
        this.tipo_animal = tipo_animal;
        this.nome_animal = nome_animal;
        this.raca = raca;
        this.idade = idade;
        this.cpf_dono_animal = cpf_dono_animal;
        animais = new ArrayList<Animal>();
    }
 
    
    
    public TableModel all() {
        String sql = "select * from animal";
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
        String sql = "select animal.tipo_animal, animal.nome_animal, animal.cpf_dono_animal from animal";
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
        String sql = "select * from animal where id_animal like ?";
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
        String sql = "insert into animal(tipo_animal, nome_animal, raca, idade, cpf_dono_animal) values(?, ?, ?, ?, ?)";
        
        try {
            this.conectar();
            pst = this.conexao.prepareStatement(sql);
            pst.setString(1, getTipo_animal());
            pst.setString(2, getNome_animal());
            pst.setString(3, getRaca());
            pst.setString(4, getIdade());
            pst.setString(5, getCpf_dono_animal());
            pst.executeUpdate();
            System.out.println("Animal cadastrado com sucesso!");
            this.desconectar(this.conexao);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public boolean update(String tipo_animal, String nome_animal, String raca, String idade, String cpf_dono_animal, int id) {
        String sql = "update animal set tipo_animal=?, nome_animal=?, raca=?, idade=?, cpf_dono_animal=? where id_animal=?";
        
        try {
            this.conectar();
            pst = this.conexao.prepareStatement(sql);
            pst.setString(1, tipo_animal);
            pst.setString(2, nome_animal);
            pst.setString(3, raca);
            pst.setString(4, idade);
            pst.setString(5, cpf_dono_animal);
            pst.setInt(6, id);
            pst.executeUpdate();
            System.out.println("Animal editado com sucesso!");
            this.desconectar(this.conexao);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public boolean destroy(String tipo_animal, String nome_animal, String cpf_dono_animal) {
        String sql = "delete from animal where tipo_animal =?  and nome_animal =? and cpf_dono_animal =?";
        
        try {
            this.conectar();
            pst = this.conexao.prepareStatement(sql);
            pst.setString(1, tipo_animal);
            pst.setString(2, nome_animal);
            pst.setString(3, cpf_dono_animal);
            pst.executeUpdate();
            System.out.println("Animal excluído com sucesso!");
            this.desconectar(this.conexao);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    /**
     * @return the tipo_animal
     */
    public String getTipo_animal() {
        return tipo_animal;
    }

    /**
     * @param tipo_animal the tipo_animal to set
     */
    public void setTipo_animal(String tipo_animal) {
        this.tipo_animal = tipo_animal;
    }

    /**
     * @return the nome_animal
     */
    public String getNome_animal() {
        return nome_animal;
    }

    /**
     * @param nome_animal the nome_animal to set
     */
    public void setNome_animal(String nome_animal) {
        this.nome_animal = nome_animal;
    }

    /**
     * @return the raca
     */
    public String getRaca() {
        return raca;
    }

    /**
     * @param raca the raca to set
     */
    public void setRaca(String raca) {
        this.raca = raca;
    }

    /**
     * @return the idade
     */
    public String getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(String idade) {
        this.idade = idade;
    }

    /**
     * @return the cpf_dono_animal
     */
    public String getCpf_dono_animal() {
        return cpf_dono_animal;
    }

    /**
     * @param cpf_dono_animal the cpf_dono_animal to set
     */
    public void setCpf_dono_animal(String cpf_dono_animal) {
        this.cpf_dono_animal = cpf_dono_animal;
    }
        
}
