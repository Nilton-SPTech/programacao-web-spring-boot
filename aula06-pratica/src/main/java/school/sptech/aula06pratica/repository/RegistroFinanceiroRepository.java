package school.sptech.aula06pratica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.sptech.aula06pratica.entity.RegistroFinanceiro;

@Repository
public interface RegistroFinanceiroRepository
        extends JpaRepository<RegistroFinanceiro, Integer> {


}
