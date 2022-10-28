package Autentica;

public class Cliente implements Autenticavel{

    String senha = "12345";
    
    @Override
    public boolean autentica(String senha) {
        if(this.senha.equals(senha)) {
            System.out.println("CLIENTE autenticado!");
            return true;
        }
        else {
           System.out.println("Não foi possível autenticar o CLIENTE!");
           return false; 
        }
    }
    
}
