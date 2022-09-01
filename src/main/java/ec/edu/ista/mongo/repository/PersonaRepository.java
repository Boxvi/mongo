package ec.edu.ista.mongo.repository;

import ec.edu.ista.mongo.model.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends MongoRepository<Persona, Long> {
}
