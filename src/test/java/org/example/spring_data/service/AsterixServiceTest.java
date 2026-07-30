package org.example.spring_data.service;

import org.example.spring_data.dto.AsterixCharacterDto;
import org.example.spring_data.model.AsterixCharacter;
import org.example.spring_data.repository.CharacterRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AsterixServiceTest {

    // mocks erstellen also die gefackten Objekte
    //wir übergeben mockito den bauplan class und der sieht welche methoden existieren und baut eine attrappe danach
    private final CharacterRepository repo = mock(CharacterRepository.class);
    private final IdService idService = mock(IdService.class);

    //der echte service wird mit mock gefüttert
    private final AsterixService service = new AsterixService(repo, idService);


    @Test
    void getAllCharacters_shouldReturnListOfCharacters() {
        //given; wir geben hier eine liste als attrappe
        AsterixCharacter c1 = new AsterixCharacter("1", "Asterix", 35, "Krieger");
        when(repo.findAll()).thenReturn(List.of(c1));

        //when; wir rufen getallcharacters auf da wir das testen wollen
        List<AsterixCharacter> actual = service.getAllCharacters();

        //then; vergleich ob die liste tatsächlich gleich mit dem ergebnis actual ist
        assertEquals(List.of(c1), actual);
    }

    @Test
    void saveCharacter_shouldSaveAndReturnCharacterWithGeneratedId() {
        // GIVEN
        AsterixCharacterDto dto = new AsterixCharacterDto("Obelix", 35, "Lieferant");

        // wir mocken idservice der uns id123 geben soll
        when(idService.randomId()).thenReturn("test-id-123");

        AsterixCharacter expectedToSave = new AsterixCharacter("test-id-123", "Obelix", 35, "Lieferant");
        when(repo.save(expectedToSave)).thenReturn(expectedToSave);

        // WHEN
        AsterixCharacter actual = service.saveCharacter(dto);

        // THEN
        assertEquals(expectedToSave, actual);
    }
}
