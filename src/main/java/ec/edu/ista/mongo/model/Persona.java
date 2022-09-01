package ec.edu.ista.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Persona {

    @Id
    private Long id;
    public  String nombre;
    public String apellido;
    public String cedula;
    public String correo;

    public Persona() {
    }
}
