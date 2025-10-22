package com.docencia.files.repo;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class FileNoteXmlRepository extends FileNoteAbstractRepository {

    private static String nameFile = "name-file.json";
    private static XmlMapper mapper = new XmlMapper();

    public FileNoteXmlRepository() {
        super(nameFile, mapper);
    }
}
