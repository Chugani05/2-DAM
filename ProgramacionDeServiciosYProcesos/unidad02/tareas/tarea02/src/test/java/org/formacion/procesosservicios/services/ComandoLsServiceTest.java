package org.formacion.procesosservicios.services;

import org.formacion.procesos.services.ComandoLsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComandoLsServiceTest {
    ComandoLsService comandoLsService;

    @BeforeEach
    void before() {
        comandoLsService = new ComandoLsService();
        comandoLsService.setComando("ls");
    }

    @Test
    void validarLaTest() {
        String[] arrayComando = {"ls", "-la"};
        boolean valida = comandoLsService.validar(arrayComando);
        Assertions.assertTrue(valida, "Se ha producido un error en la validación");
    }

    @Test
    void validarMenosTest() {
        String[] arrayComando = {"ls", "-"};
        boolean valida = comandoLsService.validar(arrayComando);
        Assertions.assertFalse(valida, "Se ha producido un error en la validación");
    }

    @Test
    void validarVacioTest() {
        String[] arrayComando = {"ls", " "};
        boolean valida = comandoLsService.validar(arrayComando);
        Assertions.assertTrue(valida, "Se ha producido un error en la validación");
    }

    @Test
    void validarSinVacioTest() {
        String[] arrayComando = {"ls", ""};
        boolean valida = comandoLsService.validar(arrayComando);
        Assertions.assertTrue(valida, "Se ha producido un error en la validación");
    }

    @Test
    void validarFalseTest() {
        String[] arrayComando = {"ls", "lalalala"};
        boolean valida = comandoLsService.validar(arrayComando);
        Assertions.assertFalse(valida, "Se ha producido un error en la validación");
    }

    @Test
    void validarFalse2Test() {
        String[] arrayComando = {"ls", "-lalalala"};
        boolean valida = comandoLsService.validar(arrayComando);
        Assertions.assertFalse(valida, "Se ha producido un error en la validación");
    }

}
