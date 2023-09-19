package school.sptech.aula07.validacoesdecampo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.aula07.validacoesdecampo.entity.Musica;

public interface MusicaRepository extends JpaRepository<Musica, Integer> {
}
