package com.docencia.objetos.repo;

import com.docencia.objetos.repo.jpa.RolEntity;
import com.docencia.objetos.repo.jpa.RolJpaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("h2")
class RolJpaRepositoryTest {

    @Autowired
    private RolJpaRepository rolJpaRepo;

    private boolean hasMethod(String name, Class<?>... parameterTypes) {
        try {
            Method m = rolJpaRepo.getClass().getMethod(name, parameterTypes);
            return m != null;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    @Test
    @DisplayName("save(): guarda un rol nuevo y genera id")
    void saveGeneraIdTest() {
        RolEntity nuevo = new RolEntity(null, "ALUMNO");
        RolEntity guardado = rolJpaRepo.save(nuevo);

        assertThat(guardado.getId()).isNotNull();
        assertThat(guardado.getNombre()).isEqualTo("ALUMNO");

        Optional<RolEntity> enBd = rolJpaRepo.findById(guardado.getId());
        assertThat(enBd).isPresent();
        assertThat(enBd.get().getNombre()).isEqualTo("ALUMNO");
    }

    @Test
    @DisplayName("findById(): devuelve Optional vacío si no existe")
    void findByIdEmptyTest() {
        Optional<RolEntity> resultado = rolJpaRepo.findById(999L);
        assertThat(resultado).isEmpty();
    }

    @Test
    @DisplayName("findById(): devuelve rol si existe")
    void findByIdPresenteTest() {
        RolEntity creado = rolJpaRepo.save(new RolEntity(null, "PROFESOR"));

        Optional<RolEntity> resultado = rolJpaRepo.findById(creado.getId());

        assertThat(resultado).isPresent();
        assertThat(resultado.get().getId()).isEqualTo(creado.getId());
        assertThat(resultado.get().getNombre()).isEqualTo("PROFESOR");
    }

    @Test
    @DisplayName("findAll(): devuelve la lista de roles")
    void findAllDevuelveListaTest() {
        rolJpaRepo.save(new RolEntity(null, "R1"));
        rolJpaRepo.save(new RolEntity(null, "R2"));

        List<RolEntity> roles = rolJpaRepo.findAll();

        assertThat(roles).hasSizeGreaterThanOrEqualTo(2);
        assertThat(roles)
                .extracting(RolEntity::getNombre)
                .contains("R1", "R2");
    }

    @Test
    @DisplayName("deleteById(): elimina el rol si existe")
    void deleteByIdEliminaTest() {
        RolEntity creado = rolJpaRepo.save(new RolEntity(null, "BORRAR"));
        Long id = creado.getId();

        assertThat(rolJpaRepo.findById(id)).isPresent();

        rolJpaRepo.deleteById(id);

        assertThat(rolJpaRepo.findById(id)).isNotPresent();
    }

    @Test
    @DisplayName("count(): devuelve el número de roles en BD")
    void countDevuelveTotalTest() {
        long antes = rolJpaRepo.count();

        rolJpaRepo.save(new RolEntity(null, "A"));
        rolJpaRepo.save(new RolEntity(null, "B"));
        rolJpaRepo.save(new RolEntity(null, "C"));

        long despues = rolJpaRepo.count();

        assertThat(despues).isEqualTo(antes + 3);
    }

    @Test
    @DisplayName("findByNombre(): devuelve Optional con el rol si existe (opcional)")
    void findByNombreOpcionalTest() throws Exception {
        if (!hasMethod("findByNombre", String.class)) {
            return;
        }

        RolEntity creado = rolJpaRepo.save(new RolEntity(null, "ALUMNO"));

        Method m = rolJpaRepo.getClass().getMethod("findByNombre", String.class);
        @SuppressWarnings("unchecked")
        Optional<RolEntity> resultado = (Optional<RolEntity>) m.invoke(rolJpaRepo, "ALUMNO");

        assertThat(resultado).isPresent();
        assertThat(resultado.get().getId()).isEqualTo(creado.getId());
        assertThat(resultado.get().getNombre()).isEqualTo("ALUMNO");
    }

    @Test
    @DisplayName("existsByNombre(): true si existe, false en caso contrario (opcional)")
    void existsByNombreOpcionalTest() throws Exception {
        if (!hasMethod("existsByNombre", String.class)) {
            return;
        }

        rolJpaRepo.save(new RolEntity(null, "EXISTE"));

        Method m = rolJpaRepo.getClass().getMethod("existsByNombre", String.class);
        Boolean existe = (Boolean) m.invoke(rolJpaRepo, "EXISTE");
        Boolean noExiste = (Boolean) m.invoke(rolJpaRepo, "NO");

        assertThat(existe).isTrue();
        assertThat(noExiste).isFalse();
    }
}
