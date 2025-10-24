package com.docencia.repo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.docencia.files.model.Note;
import com.docencia.files.repo.FileNoteRepository;

public class FileNoteRepositoryTest {

    static FileNoteRepository fileNoteRepository;
    Note element;
    Note findElement;
    String id = "00001";
    String title = "title";
    String content = "content";

    @BeforeEach
    static void beforeEach() {
        fileNoteRepository = new FileNoteRepository();
        element = new Note(id, title, content);
        findElement = fileNoteRepository.find(element);
        Assertions.assertNull(findElement, "El elemento debe ser null");
    }

    @AfterEach
    void afterEach() {
        findElement = fileNoteRepository.findById(id);
        Assertions.assertNull(findElement, "El elemento debe ser null");
    }

    @Test
    void createFileTest() {
        Assertions.assertNotNull(fileNoteRepository, "El repositorio no debe de ser nulo");
    }

    @Test
    void insertNoteTest() {
        Note result = fileNoteRepository.findById(null);
        Assertions.assertNotNull(result, "El repositorio no debe de ser nulo");
        Assertions.assertEquals(result, result , "El valor no es el esperado");
    }
}
