package ec.edu.ista.mongo.service.impl;

import ec.edu.ista.mongo.model.Persona;
import ec.edu.ista.mongo.repository.PersonaRepository;
import ec.edu.ista.mongo.service.GenericService;
import ec.edu.ista.mongo.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class PersonaServiceImplement extends GenericServiceImplement<Persona,Long> implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public CrudRepository<Persona, Long> getDao() {
        return personaRepository;
    }

    /*
    @Override
    public Persona save(Persona entity) {
        return personaRepository.save(entity);
    }

    @Override
    public Persona findById(Long aLong) {
        return personaRepository.findById(aLong).orElse(new Persona());
    }

    @Override
    public List<Persona> findByAll() {
        return personaRepository.findAll();
    }

    @Override
    public void delete(Long aLong) {

        personaRepository.deleteById(aLong);
    }*/
}
