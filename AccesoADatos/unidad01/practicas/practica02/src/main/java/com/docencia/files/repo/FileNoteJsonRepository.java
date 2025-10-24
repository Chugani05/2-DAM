package com.docencia.files.repo;

import com.fasterxml.jackson.databind.json.JsonMapper;

public class FileNoteJsonRepository extends FileNoteAbstractRepository {

    private static String nameFile = "note-repository.json";
    private static JsonMapper mapper = new JsonMapper();

    public FileNoteJsonRepository() {
        super(nameFile, mapper);
    }
}
