package mk.finki.ukim.wp.birdenricher.service;

import mk.finki.ukim.wp.birdenricher.model.SqlQuery;
import java.util.List;

public interface SqlQueryService {
    List<SqlQuery> findAll();
    SqlQuery findById(Long id);
    SqlQuery create(SqlQuery q);
    SqlQuery update(Long id, SqlQuery q);
    void delete(Long id);
    List<SqlQuery> findBySchema(String schema);
}