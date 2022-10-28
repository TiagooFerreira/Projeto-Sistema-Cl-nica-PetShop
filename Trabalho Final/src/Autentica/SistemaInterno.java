package Autentica;

public class SistemaInterno {
    public void login(Autenticavel a) {
        String senha = "12345";
        if(a.autentica(senha))
            System.out.println("Funcionario autenticado!");
        else
            System.out.println("Não foi possível fazer o login!");
    }
}
