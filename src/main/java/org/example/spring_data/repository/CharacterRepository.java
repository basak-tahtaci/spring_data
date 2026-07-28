package org.example.spring_data.repository;

import org.example.spring_data.model.AsterixCharacter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends MongoRepository<AsterixCharacter, String> {
}
