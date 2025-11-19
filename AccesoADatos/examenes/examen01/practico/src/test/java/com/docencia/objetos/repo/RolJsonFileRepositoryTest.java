package com.docencia.objetos.repo;

import com.docencia.objetos.domain.Rol;
import com.docencia.objetos.repo.json.RolJsonFileRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class RolJsonFileRepositoryTest {

    private Path baseDir;

@BeforeEach
    void setUp() throws Exception {
        baseDir = Paths.get("target", "test-roles");
        Files.createDirectories(baseDir);
    }

    @AfterEach
    void tearDown() throws Exception {
        if (baseDir != null && Files.exists(baseDir)) {
            Files.list(baseDir).forEach(p -> {
                try {
                    Files.deleteIfExists(p);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    private RolJsonFileRepository crearRepo(String fileName) {
        Path file = baseDir.resolve(fileName);
        ObjectMapper mapper = new ObjectMapper();
        return new RolJsonFileRepository(file, mapper);
    }

    @Test
    @DisplayName("save(): guarda un rol nuevo, genera id y lo vuelca al fichero JSON")
    void saveNuevoGeneraIdYSeVuelcaEnFicheroTest() throws Exception {
        RolJsonFileRepository repo = crearRepo("roles.json");
        Rol nuevo = new Rol(null, "ALUMNO");
        Rol guardado = repo.save(nuevo);
        assertThat(guardado.getId()).isNotNull();
        Path file = baseDir.resolve("roles.json");
        assertThat(Files.exists(file)).isTrue();
        String contenido = Files.readString(file);
        assertThat(contenido).contains("ALUMNO");
    }

    @Test
    @DisplayName("findAll(): devuelve todos los roles leídos desde el fichero JSON")
    void findAllDevuelveRolesDesdeFicheroTest() {
        RolJsonFileRepository repo = crearRepo("roles.json");
        repo.save(new Rol(null, "ALUMNO"));
        repo.save(new Rol(null, "PROFESOR"));
        List<Rol> roles = repo.findAll();
        assertThat(roles).hasSize(2);
        assertThat(roles)
                .extracting(Rol::getNombre)
                .containsExactlyInAnyOrder("ALUMNO", "PROFESOR");
    }

    @Test
    @DisplayName("findById(): devuelve Optional vacío si el id no existe")
    void findByIdNoExistenteDevuelveEmptyTest() {
        RolJsonFileRepository repo = crearRepo("roles.json");
        repo.save(new Rol(null, "ALUMNO"));
        Optional<Rol> resultado = repo.findById(999L);
        assertThat(resultado).isEmpty();
    }

    @Test
    @DisplayName("findById(): devuelve el rol correcto cuando el id existe")
    void findByIdExistenteDevuelveRolTest() {
        RolJsonFileRepository repo = crearRepo("roles.json");
        Rol guardado = repo.save(new Rol(null, "ALUMNO"));
        Optional<Rol> resultado = repo.findById(guardado.getId());
        assertThat(resultado).isPresent();
        Rol rol = resultado.orElseThrow();
        assertThat(rol.getId()).isEqualTo(guardado.getId());
        assertThat(rol.getNombre()).isEqualTo("ALUMNO");
    }

    @Test
    @DisplayName("findByNombre(): devuelve el rol cuando el nombre existe")
    void findByNombreExistenteDevuelveRolTest() {
        RolJsonFileRepository repo = crearRepo("roles.json");
        repo.save(new Rol(null, "ALUMNO"));
        repo.save(new Rol(null, "PROFESOR"));
        Optional<Rol> resultado = repo.findByNombre("PROFESOR");
        assertThat(resultado).isPresent();
        assertThat(resultado.get().getNombre()).isEqualTo("PROFESOR");
    }

    @Test
    @DisplayName("deleteById(): elimina el rol del fichero si existe")
    void deleteByIdEliminaRolDelFicheroTest() {
        RolJsonFileRepository repo = crearRepo("roles.json");
        Rol guardado = repo.save(new Rol(null, "BORRAR"));
        assertThat(repo.findById(guardado.getId())).isPresent();
        repo.deleteById(guardado.getId());
        assertThat(repo.findById(guardado.getId())).isNotPresent();
        assertThat(repo.count()).isZero();
    }

    @Test
    @DisplayName("count(): devuelve el número de roles almacenados en el fichero JSON")
    void countDevuelveNumeroDeRolesTest() {
        RolJsonFileRepository repo = crearRepo("roles.json");
        repo.save(new Rol(null, "ALUMNO"));
        repo.save(new Rol(null, "PROFESOR"));
        repo.save(new Rol(null, "ADMIN"));
        long total = repo.count();
        assertThat(total).isEqualTo(3L);
    }
}