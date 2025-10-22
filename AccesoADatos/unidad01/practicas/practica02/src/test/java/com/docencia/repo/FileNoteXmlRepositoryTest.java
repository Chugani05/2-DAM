package com.docencia.repo;

import org.junit.jupiter.api.Test;

import com.docencia.files.repo.FileNoteXmlRepository;

class FileNoteXmlRepositoryTest {
    FileNoteXmlRepository fileNoteXmlRepository;

    @Test
    void createFileTest() {
        fileNoteXmlRepository = new FileNoteXmlRepository();
    }
}
