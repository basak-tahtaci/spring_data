package org.example.spring_data.service;

import org.example.spring_data.model.AsterixCharacter;
import org.example.spring_data.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsterixService {

    // Dependency Injection; wie Mehl vor Brot, Spring injiziert das repo in Service damit Controller zugreift
    private final CharacterRepository repo;

    // hier passiert die DI; der Konstruktor AsterixService legt fest, wenn jemand ein service objekt erstellen möchte,
    // muss er characterrepo übergeben
    public AsterixService(CharacterRepository repo) {
        this.repo = repo;
    }
    // this.repo = repo;: Hier nimmt die Klasse das von Spring übergebene repo und speichert es in ihrer eigenen
    // Variable private final CharacterRepository repo; ab. Ab diesem Moment kann die gesamte Klasse mit this.repo auf
    // die Datenbank zugreifen.

    // methode holt über findAll Charaktere aus DB ab und gibt sie als liste zurück
    public List<AsterixCharacter> getAllCharacters() {
        return repo.findAll();
    }

    // nimmt den asterixcharacter objekt also neuen charakter und speichert es über save in DB, save ist eine methode
    // von springboot
    public AsterixCharacter saveCharacter(AsterixCharacter character) {
        return repo.save(character);
    }


}
