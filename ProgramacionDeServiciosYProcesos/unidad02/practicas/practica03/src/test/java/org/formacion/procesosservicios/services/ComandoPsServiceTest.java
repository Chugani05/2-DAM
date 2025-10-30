package org.formacion.procesosservicios.services;

import org.formacion.procesos.services.ComandoPsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComandoPsServiceTest {
    ComandoPsService comandoPsService;

    @BeforeEach
    void before() {
        comandoPsService = new ComandoPsService();
        comandoPsService.setComando("ps");
    }

    @Test
    void validarXaTest() {
        String[] arrayComando = {"ps", "xa"};
        boolean valida = comandoPsService.validar(arrayComando);
        Assertions.assertTrue(valida, "Se ha producido un error en la validación");
    }

    @Test
    void validarXaMenosTest() {
        String[] arrayComando = {"ps", "-xa"};
        boolean valida = comandoPsService.validar(arrayComando);
        Assertions.assertTrue(valida, "Se ha producido un error en la validación");
    }

    @Test
    void validarMenosTest() {
        String[] arrayComando = {"ps", "-"};
        boolean valida = comandoPsService.validar(arrayComando);
        Assertions.assertFalse(valida, "Se ha producido un error en la validación");
    }

    @Test
    void validarVacioTest() {
        String[] arrayComando = {"ps", " "};
        boolean valida = comandoPsService.validar(arrayComando);
        Assertions.assertTrue(valida, "Se ha producido un error en la validación");
    }

    @Test
    void validarSinVacioTest() {
        String[] arrayComando = {"ps", ""};
        boolean valida = comandoPsService.validar(arrayComando);
        Assertions.assertTrue(valida, "Se ha producido un error en la validación");
    }

    @Test
    void validarFalseTest() {
        String[] arrayComando = {"ps", "lalalala"};
        boolean valida = comandoPsService.validar(arrayComando);
        Assertions.assertFalse(valida, "Se ha producido un error en la validación");
    }

    @Test
    void validarFalse2Test() {
        String[] arrayComando = {"ps", "-lalalala"};
        boolean valida = comandoPsService.validar(arrayComando);
        Assertions.assertFalse(valida, "Se ha producido un error en la validación");
    }

}
