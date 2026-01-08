package com.docencia.aed.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docencia.aed.entity.Publisher;
import com.docencia.aed.repository.PublisherRepository;
import com.docencia.aed.service.interfaces.IPublisherService;

/**
 * Class PublisherService
 * Es el servicio que gestiona la lógica relacionada con las editoriales.
 * 
 * @author Chugani05 
 */
@Service
public class PublisherService implements IPublisherService {

    private final PublisherRepository repository;

    @Autowired
    public PublisherService(PublisherRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Publisher> findAll() {
        return repository.findAll();
    }

    @Override
    public Publisher create(Publisher name) {
        return repository.save(name);
    }
}
