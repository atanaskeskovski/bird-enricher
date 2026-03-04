package mk.finki.ukim.wp.birdenricher.repo;

import mk.finki.ukim.wp.birdenricher.model.SqlQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SqlQueryRepository extends JpaRepository<SqlQuery, Long> {
}