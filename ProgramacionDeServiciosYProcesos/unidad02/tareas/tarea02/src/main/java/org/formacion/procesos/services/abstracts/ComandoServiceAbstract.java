package org.formacion.procesos.services.abstracts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.formacion.procesos.domain.ProcessType;
import org.formacion.procesos.repositories.interfaces.CrudInterface;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ComandoServiceAbstract {
    private String comando;
    private ProcessType tipo;
    
    private String regExp;


    @Autowired
    CrudInterface fileRepository;


    public CrudInterface getFileRepository() {
        return fileRepository
    }

    public void setFileRepository(CrudInterface fileRepository) {
        this.fileRepository
    }
    


    public String getRegExp() {
        return regExp;
    }



    public void setRegExp(String regExp) {
        this.regExp = regExp;
    }



    public void setComando(String comando) {
        this.comando = comando;
    }



    public String getComando() {
        return comando;
    }



    public String getTipoToString() {
        if (tipo == null) {
            return null;
        }
        return tipo.toString();
    }



    public void setTipo(ProcessType tipo) {
        this.tipo = tipo;
    }
    


    public void procesarLinea(String linea) {
        String[] arrayComando = linea.split("\s*");
        this.setComando(arrayComando[0]);
        System.out.println("Comando:"+this.getComando());
        if (!validar(arrayComando)) {
            System.out.println("El comando es invalido");
        }

        Process proceso;
        try {
            proceso = new ProcessBuilder("sh", "-c", linea +" > mis_procesos.txt")
            .start();
            proceso.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public boolean ejecutarProceso(Process proceso) {
        try {
            proceso.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;    
    }



    public boolean validar(String[] arrayComando) {
        if (!validarComando()) {
            return false;
        }
        String parametro = arrayComando[1];

        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(parametro);
        if (!matcher.find()) {
            System.out.println("No cumple");
            return false;
        }
        return true;
    }



    public boolean validarComando() {
        if (!getComando().toUpperCase().equals(getTipoToString())) {
            System.out.println("El comando es invalido");
            return false;
        }
        return true;
    }
}
