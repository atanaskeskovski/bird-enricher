package mk.finki.ukim.wp.birdenricher.service.impl;

import mk.finki.ukim.wp.birdenricher.model.SqlQuery;
import mk.finki.ukim.wp.birdenricher.repo.SqlQueryRepository;
import mk.finki.ukim.wp.birdenricher.service.SqlQueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaSqlQueryService implements SqlQueryService {

    private final SqlQueryRepository sqlQueryRepository;

    public JpaSqlQueryService(SqlQueryRepository repo) {
        this.sqlQueryRepository = repo;
    }

    @Override
    public List<SqlQuery> findAll() {
        return sqlQueryRepository.findAll();
    }

    @Override
    public SqlQuery findById(Long id) {
        return sqlQueryRepository.findById(id).orElseThrow();
    }

    @Override
    public SqlQuery create(SqlQuery q) {
        return sqlQueryRepository.save(q);
    }

    @Override
    public List<SqlQuery> findBySchema(String schema) {
        return sqlQueryRepository.findBySchemaNameContainingIgnoreCase(schema);
    }

    @Override
    public SqlQuery update(Long id, SqlQuery q) {
        SqlQuery existing = findById(id);
        existing.setQuestion(q.getQuestion());
        existing.setSchemaName(q.getSchemaName());
        existing.setDifficulty(q.getDifficulty());
        existing.setSqlAnswer(q.getSqlAnswer());
        existing.setChatgptValid(q.isChatgptValid());
        existing.setNotes(q.getNotes());
        existing.setSchemaDdl(q.getSchemaDdl());
        return sqlQueryRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        sqlQueryRepository.deleteById(id);
    }
}