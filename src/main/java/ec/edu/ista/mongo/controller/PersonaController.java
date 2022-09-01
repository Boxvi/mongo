package ec.edu.ista.mongo.controller;

import ec.edu.ista.mongo.model.Persona;
import ec.edu.ista.mongo.service.impl.PersonaServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    private Persona persona;

    @Autowired
    private PersonaServiceImplement personaServiceImplement;

    //sbid
    @GetMapping("/{id}")
    public ResponseEntity<Persona> read(@PathVariable Long id){
        persona = personaServiceImplement.findById(id);
        if (!(persona ==null)){
            return new ResponseEntity<>(persona, HttpStatus.OK);

        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //c

    @PostMapping("/crear")
    public ResponseEntity<Persona> create(@RequestBody Persona persona){
        return new ResponseEntity<>(personaServiceImplement.save(persona), HttpStatus.OK);
    }

    //r
    @GetMapping("/list")
    public ResponseEntity<List<Persona>> read() {
        return new ResponseEntity<>(personaServiceImplement.findByAll(), HttpStatus.OK);
    }


    //u
    @PutMapping("{id}")
    public ResponseEntity<Persona> update(@PathVariable Long id, @RequestBody Persona persona1){
        persona = personaServiceImplement.findById(id);
        if (!(persona == null)) {
            persona.setNombre(persona1.getNombre());
            persona.setApellido(persona1.getApellido());
            persona.setCorreo(persona1.getCorreo());

            return new ResponseEntity<>(personaServiceImplement.save(persona), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //d
    @DeleteMapping("/{id}")
    public ResponseEntity<Persona> delete(@PathVariable Long id) {
        persona = personaServiceImplement.findById(id);
        if (!(persona == null)) {
            personaServiceImplement.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
/*

    //UPDATE
    @PutMapping("/{titulo}/{nombre}")
    public ResponseEntity<Cancion> update(@PathVariable String titulo,@PathVariable String nombre, @RequestBody Cancion cancione) {
        cancion = cancionServiceImpl.findById(titulo);
        if (!(cancion == null)) {
            try {
                cancion.setAlbum(cancione.getAlbum());
                cancion.setArtista(cancione.getArtista());
                cancion.setAnio(cancione.getAnio());
                cancion.setLista(listaServiceImpl.findById(nombre));
                return new ResponseEntity<>(cancionServiceImpl.save(cancion), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //READ




    //DELETE

}

 */