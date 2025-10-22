package com.docencia.files.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.docencia.files.repo.INoteRepository;

public abstract class ServiceNoteAbstract implements IServiceNote {

    @Autowired
    INoteRepository noteRepository;

    public INoteRepository getNoteRepository() {
        return noteRepository;
    }

}