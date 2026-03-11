/*package mk.finki.ukim.wp.birdenricher.service.impl;

import mk.finki.ukim.wp.birdenricher.model.SqlQuery;
import mk.finki.ukim.wp.birdenricher.service.SqlQueryService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

//@Service
//@Primary
public class InMemorySqlQueryService implements SqlQueryService {

    private final Map<Long, SqlQuery> store = new LinkedHashMap<>();
    private final AtomicLong idGen = new AtomicLong(0);

    @Override
    public List<SqlQuery> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public SqlQuery findById(Long id) {
        SqlQuery q = store.get(id);
        if (q == null) throw new NoSuchElementException("SqlQuery not found: " + id);
        return q;
    }

    @Override
    public SqlQuery create(SqlQuery q) {
        long id = idGen.incrementAndGet();
        q.setId(id);
        store.put(id, q);
        return q;
    }

    @Override
    public SqlQuery update(Long id, SqlQuery q) {
        findById(id);
        q.setId(id);
        store.put(id, q);
        return q;
    }

    @Override
    public void delete(Long id) {
        store.remove(id);
    }
}*/