package mk.finki.ukim.wp.birdenricher.repo;

import mk.finki.ukim.wp.birdenricher.model.SqlQuery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SqlQueryRepository extends JpaRepository<SqlQuery, Long> {
    List<SqlQuery> findBySchemaNameContainingIgnoreCase(String schemaName);
}