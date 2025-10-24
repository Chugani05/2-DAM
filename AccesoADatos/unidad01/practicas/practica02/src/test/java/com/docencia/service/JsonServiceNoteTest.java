package com.docencia.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.docencia.files.model.Note;
import com.docencia.files.service.JsonServiceNote;

class JsonServiceNoteTest {

    JsonServiceNote jsonServiceNote;
    Note note;

    @BeforeEach
    void beforeEach() {
        jsonServiceNote = new JsonServiceNote();
        note = new Note("1", "Titulo", "Contenido");
    }

    @Test
    void serializeNote() {
        String noteStr = jsonServiceNote.noteToString(note);
        Note noteTest = jsonServiceNote.stringToNote(noteStr);
        Assertions.assertEquals(note, noteTest, "The objects need to be equals!");
    }
}
