package com.docencia.personas.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.docencia.personas.model.Rol;
import com.docencia.personas.services.IRoleService;

@SpringBootTest
public class RolServiceTest {

    private static final String ROLE_NOMBRE = "Role nombre";
    private static final String ROL_ID = "ROL-1";
    IRoleService roleService;
    Rol rol;
    
    @Autowired
    public void setRoleService(IRoleService roleService) {
        this.roleService = roleService;
    }

    @BeforeEach
    void beforeEach() {
        if (rol == null) {
            rol = new Rol(ROL_ID, ROLE_NOMBRE);
        }
        roleService.save(rol);
    }

    @Test
    void findByTest() {
        Rol rolFind = new Rol(ROL_ID);
        rolFind = roleService.findBy(rolFind);
        Assertions.assertNotNull(rolFind);
        Assertions.assertEquals(rol, rolFind);
        Assertions.assertEquals(ROL_ID, rolFind.getId());
        Assertions.assertEquals(ROLE_NOMBRE, rolFind.getNombre());
    }

    @AfterEach
    void afterEach() {
        Rol rolDelete = new Rol(ROL_ID);
        roleService.delete(rolDelete);
        rolDelete = new Rol(ROL_ID);
        Assertions.assertNull(rolDelete);
    }
}
