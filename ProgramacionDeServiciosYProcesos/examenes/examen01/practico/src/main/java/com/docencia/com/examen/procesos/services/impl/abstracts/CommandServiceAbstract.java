package com.docencia.com.examen.procesos.services.impl.abstracts;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

import com.docencia.com.examen.procesos.domain.Job;
import com.docencia.com.examen.procesos.repositories.interfaces.JobRepository;
import com.docencia.com.examen.procesos.services.interfaces.CommandService;


public abstract class CommandServiceAbstract implements CommandService {
    

    @Override
    public boolean processLine(String command, boolean changeCmd) {
        return false;
    }

    
}
