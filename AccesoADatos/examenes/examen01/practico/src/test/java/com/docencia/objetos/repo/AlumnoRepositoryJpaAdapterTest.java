package com.docencia.objetos.repo;

import com.docencia.objetos.domain.Alumno;
import com.docencia.objetos.domain.Rol;
import com.docencia.objetos.repo.jpa.AlumnoEntity;
import com.docencia.objetos.repo.jpa.AlumnoJpaRepository;
import com.docencia.objetos.repo.jpa.RolEntity;
import com.docencia.objetos.repo.jpa.RolJpaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@ActiveProfiles("h2")
@Import(AlumnoRepositoryJpaAdapter.class)
class AlumnoRepositoryJpaAdapterTest {

    @Autowired
    private AlumnoRepositoryJpaAdapter repo;

    @Autowired
    private AlumnoJpaRepository jpaRepo;

    @Autowired
    private RolJpaRepository rolJpaRepo;

    @Test
    @DisplayName("save(): guarda un alumno nuevo sin rol y devuelve dominio con id generado")
    void creaAlumnoConIdGeneradoTest() {
        
        Alumno nuevo = new Alumno(null, "Pepe Pérez", "pepe@example.com", "DAM");

        
        Alumno guardado = repo.save(nuevo);

        
        assertThat(guardado.getId()).isNotNull();
        assertThat(guardado.getNombre()).isEqualTo("Pepe Pérez");
        assertThat(guardado.getEmail()).isEqualTo("pepe@example.com");
        assertThat(guardado.getCiclo()).isEqualTo("DAM");
        assertThat(guardado.getRol()).isNull();

        
        AlumnoEntity entity = jpaRepo.findById(guardado.getId()).orElseThrow();
        assertThat(entity.getNombre()).isEqualTo("Pepe Pérez");
        assertThat(entity.getEmail()).isEqualTo("pepe@example.com");
        assertThat(entity.getCiclo()).isEqualTo("DAM");
        assertThat(entity.getRol()).isNull();
    }

    @Test
    @DisplayName("save() + findById(): mapean correctamente la relación Alumno–Rol")
    void saveYFindByIdMapeanRolEntreDominioYEntidadTest() {
        
        RolEntity rolEntity = rolJpaRepo.save(new RolEntity(null, "ALUMNO"));

        Alumno nuevo = new Alumno(
                null,
                "Laura López",
                "laura@example.com",
                "DAM",
                new Rol(rolEntity.getId(), rolEntity.getNombre())
        );

        
        Alumno guardado = repo.save(nuevo);

        
        assertThat(guardado.getId()).isNotNull();
        assertThat(guardado.getRol()).isNotNull();
        assertThat(guardado.getRol().getId()).isEqualTo(rolEntity.getId());
        assertThat(guardado.getRol().getNombre()).isEqualTo("ALUMNO");

        
        Alumno buscado = repo.findById(guardado.getId()).orElseThrow();
        assertThat(buscado.getRol()).isNotNull();
        assertThat(buscado.getRol().getId()).isEqualTo(rolEntity.getId());
        assertThat(buscado.getRol().getNombre()).isEqualTo("ALUMNO");

        
        AlumnoEntity entity = jpaRepo.findById(guardado.getId()).orElseThrow();
        assertThat(entity.getRol()).isNotNull();
        assertThat(entity.getRol().getId()).isEqualTo(rolEntity.getId());
        assertThat(entity.getRol().getNombre()).isEqualTo("ALUMNO");
    }

    @Test
    @DisplayName("findAll(): devuelve lista de alumnos en dominio")
    void devuelveListaAlumnosTest() {
        
        jpaRepo.save(new AlumnoEntity(null, "A", "a@example.com", "DAM"));
        jpaRepo.save(new AlumnoEntity(null, "B", "b@example.com", "DAM"));

        
        List<Alumno> alumnos = repo.findAll();

        
        assertThat(alumnos).hasSize(2);
        assertThat(alumnos)
                .extracting(Alumno::getNombre)
                .containsExactlyInAnyOrder("A", "B");
    }

    @Test
    @DisplayName("findById(): devuelve Optional vacío si no existe")
    void noExistenteDevuelveEmptyTest() {
        
        Optional<Alumno> resultado = repo.findById(999L);

        
        assertThat(resultado).isEmpty();
    }

    @Test
    @DisplayName("findById(): devuelve Optional con Alumno mapeado si existe")
    void existenteDevuelveAlumnoTest() {
        
        AlumnoEntity entity = jpaRepo.save(
                new AlumnoEntity(null, "Carlos", "carlos@example.com", "ASIR")
        );

        
        Optional<Alumno> resultado = repo.findById(entity.getId());

        
        assertThat(resultado).isPresent();
        Alumno alumno = resultado.orElseThrow();
        assertThat(alumno.getId()).isEqualTo(entity.getId());
        assertThat(alumno.getNombre()).isEqualTo("Carlos");
        assertThat(alumno.getEmail()).isEqualTo("carlos@example.com");
        assertThat(alumno.getCiclo()).isEqualTo("ASIR");
        assertThat(alumno.getRol()).isNull();
    }

    @Test
    @DisplayName("existsByEmail(): true si el email existe, false en caso contrario")
    void existsByEmailFuncionaCorrectamenteTest() {
        
        jpaRepo.save(new AlumnoEntity(null, "Ana", "ana@example.com", "DAM"));

        
        assertThat(repo.existsByEmail("ana@example.com")).isTrue();
        assertThat(repo.existsByEmail("otro@example.com")).isFalse();
    }

    @Test
    @DisplayName("deleteById(): elimina el alumno si existe")
    void deleteByIdAlumnoTest() {
        
        AlumnoEntity entity = jpaRepo.save(
                new AlumnoEntity(null, "Borrar", "borrar@example.com", "DAM")
        );
        Long id = entity.getId();

        // precondición
        assertThat(jpaRepo.findById(id)).isPresent();

        
        repo.deleteById(id);

        
        assertThat(jpaRepo.findById(id)).isNotPresent();
    }

    @Test
    @DisplayName("count(): devuelve el número de alumnos en BD")
    void countDevuelveNumeroDeAlumnosTest() {
        
        jpaRepo.save(new AlumnoEntity(null, "A", "a1@example.com", "DAM"));
        jpaRepo.save(new AlumnoEntity(null, "B", "b1@example.com", "DAM"));
        jpaRepo.save(new AlumnoEntity(null, "C", "c1@example.com", "ASIR"));

        
        long total = repo.count();

        
        assertThat(total).isEqualTo(3L);
    }

    @Test
    @DisplayName("save(): respeta restricción de email único (lanza excepción)")
    void saveEmailDuplicadoLanzaExcepcionTest() {
        
        repo.save(new Alumno(null, "Uno", "dup@example.com", "DAM"));

         
        assertThrows(
                Exception.class,
                () -> repo.save(new Alumno(null, "Dos", "dup@example.com", "DAM")),
                "Debería lanzar una excepción por restricción de email único"
        );
    }
}
