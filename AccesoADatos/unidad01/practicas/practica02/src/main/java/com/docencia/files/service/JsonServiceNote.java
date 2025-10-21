package com.docencia.files.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.docencia.files.model.Note;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class JsonServiceNote extends ServiceNoteAbstract {
    JsonMapper jsonMapper;

    private static Logger logger = LoggerFactory.getLogger(XmlServiceNote.class);

    @Override
    public boolean exists(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @Override
    public Note findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Note> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Note save(Note note, Optional<String> expOpt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public String noteToString(Note note) {
        String result = null;
        try {
            result = jsonMapper.writeValueAsString(note);
        } catch (JsonProcessingException e) {
            logger.error("Se ha producido un error en la transformación de data {}", note, e);
        }
        return result;
    }

    @Override
    public Note stringToNote(String data) {
        try {
            return jsonMapper.readValue(data, Note.class);
        } catch (JsonProcessingException e) {
            logger.error("Se ha producido un error en la transformación de data {}", data, e);
        }
        return null;
    }

}
