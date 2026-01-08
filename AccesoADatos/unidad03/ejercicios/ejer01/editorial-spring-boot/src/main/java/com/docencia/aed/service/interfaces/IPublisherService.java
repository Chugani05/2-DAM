package com.docencia.aed.service.interfaces;

import java.util.List;

import com.docencia.aed.entity.Publisher;

public interface IPublisherService {

    /**
     * 
     * @return
     */
    List<Publisher> findAll();

    /**
     * 
     * @param name
     * @return
     */
    Publisher create(Publisher name);
}
