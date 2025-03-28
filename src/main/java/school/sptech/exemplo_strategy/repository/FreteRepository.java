package school.sptech.exemplo_strategy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.sptech.exemplo_strategy.entity.Frete;

@Repository
public interface FreteRepository extends JpaRepository<Frete, Integer> {


}
