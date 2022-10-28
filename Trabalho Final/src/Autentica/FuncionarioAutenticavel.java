/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Autentica;

/**
 *
 * @author tiago
 */
public abstract class FuncionarioAutenticavel extends Funcionario {
    
    public FuncionarioAutenticavel(String nome, String usuario, String senha) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public boolean autentica(String senha) {
        if(this.senha.equals(senha)) return true;
        return false;
    }
    
}
