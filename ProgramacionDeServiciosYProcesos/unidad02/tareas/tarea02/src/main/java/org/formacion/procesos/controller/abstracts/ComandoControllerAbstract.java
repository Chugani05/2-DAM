package org.formacion.procesos.controller.abstracts;

import java.util.List;

import org.formacion.procesos.domain.ProcessType;

public abstract class ComandoControllerAbstract {
    String comando;
    List<String> parametros;
    ProcessType tipo;
    

    public String getComando() {
        return comando;
    }



    public void setComando(String comando) {
        this.comando = comando;
    }



    public List<String> getParametros() {
        return parametros;
    }



    public void setParametros(List<String> parametros) {
        this.parametros = parametros;
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



    public abstract void imprimeMensaje();
    


    public void procesarLinea(String linea) {
        String[] arrayComando = linea.split(" ");
        this.setComando(arrayComando[0]);
        System.out.println("Comando:"+this.getComando());
        if (!getComando().toUpperCase().equals(getTipoToString())) {
            System.out.println("El comando es invalido");
        }

        Process proceso;
        // linea = ps aux | grep java 
        try {
            proceso = new ProcessBuilder("sh", "-c", linea +" > mis_procesos.txt")
            .start();
            proceso.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        imprimeMensaje();    
    }



    public boolean ejecutarProceso(Process proceso) {
        try {
            proceso.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;    
    }
}
