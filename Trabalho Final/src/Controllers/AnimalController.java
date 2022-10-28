package Controllers;

import Models.Animal;
import Models.Cliente;
import java.util.ArrayList;
import javax.swing.table.TableModel;

public class AnimalController {
    
    
    public TableModel index() {
        return new Animal().all();
    }
    
    public TableModel index2() {
        return new Animal().all2();
    }
    
    public TableModel findName(String busca) {
        return new Animal().findByName(busca);
    }
    
    public boolean create(String Tipo_animal, String Nome_animal, String raca, String idade, String cpf_dono_animal) {
        Animal c = new Animal(Tipo_animal, Nome_animal, raca, idade, cpf_dono_animal);
        return c.save();
    }
    
    public boolean edit(String tipo_animal, String nome_animal, String raca, String idade, String cpf_dono_animal, int id) {
        return new Animal().update(tipo_animal, nome_animal, raca, idade, cpf_dono_animal, id);
    }

    
    public boolean delete(String tipo_animal, String nome_animal, String cpf_dono_animal) {
        return new Animal().destroy(tipo_animal, nome_animal, cpf_dono_animal);
    }
}
