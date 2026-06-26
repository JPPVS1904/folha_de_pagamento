package FolhaDePagamento.repositories;

import FolhaDePagamento.domain.entities.ResultadoFolha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoFolhaRepository extends JpaRepository<ResultadoFolha, Long> {
}
