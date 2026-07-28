package org.example.spring_data.controller;

import org.example.spring_data.model.AsterixCharacter;
import org.example.spring_data.repository.CharacterRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/asterix")
public class AsterixController {

    //muss da sein bevor es gebaut wird, wie mehl vor brot backen
    private final CharacterRepository repo;

    public AsterixController(CharacterRepository repo) {
        this.repo = repo;
    }

    //das gleiche wie unten nur von der datenbank repo die daten genommen
    @GetMapping("/characters")
    public List<AsterixCharacter> getAllCharacters() {
        return repo.findAll();
    }


//    @GetMapping("/characters")
//    public List<AsterixCharacter> getAllCharacters() {
//        return List.of(
//                new AsterixCharacter("1", "Asterix", 35, "Warrior"),
//                new AsterixCharacter("2", "Obelix", 35, "Supplier"),
//                new AsterixCharacter("3", "Miraculix", 60, "Druid"),
//                new AsterixCharacter("4", "Majestix", 60, "Chief"),
//                new AsterixCharacter("5", "Troubadix", 25, "Bard"),
//                new AsterixCharacter("6", "Gutemine", 35, "Chiefs Wife"),
//                new AsterixCharacter("7", "Idefix", 5, "Dog"),
//                new AsterixCharacter("8", "Geriatrix", 70, "Retiree"),
//                new AsterixCharacter("9", "Automatix", 35, "Smith"),
//                new AsterixCharacter("10", "Grockelix", 35, "Fisherman")
//        );
//    }

}