package com.docencia.repo;

import org.junit.jupiter.api.Test;

import com.docencia.files.repo.FileNoteJsonRepository;

class FileNoteJsonRepositoryTest {
    FileNoteJsonRepository fileNoteJsonRepository;

    @Test
    void createFileTest() {
        fileNoteJsonRepository = new FileNoteJsonRepository();
    }
}
