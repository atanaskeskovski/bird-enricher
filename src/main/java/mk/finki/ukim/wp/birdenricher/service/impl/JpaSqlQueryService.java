package mk.finki.ukim.wp.birdenricher.service.impl;

import mk.finki.ukim.wp.birdenricher.model.SqlQuery;
import mk.finki.ukim.wp.birdenricher.repo.SqlQueryRepository;
import mk.finki.ukim.wp.birdenricher.service.SqlQueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaSqlQueryService implements SqlQueryService {

    private final SqlQueryRepository repo;

    public JpaSqlQueryService(SqlQueryRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<SqlQuery> findAll() {
        return repo.findAll();
    }

    @Override
    public SqlQuery findById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public SqlQuery create(SqlQuery q) {
        return repo.save(q);
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
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}