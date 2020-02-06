package test.pavelyurtaev.unique.model.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Optional;

@Repository
public class UniqueIdDao {

    @Value("${sequence-table}")
    private String uniqueSeqTableName;

    private final JdbcTemplate jdbcTemplate;

    public UniqueIdDao(final DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Optional<Long> getNumberFromSequence() {
        final StringBuilder queryBuilder = new StringBuilder().append("SELECT nextval('").append(uniqueSeqTableName).append("')");
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(queryBuilder.toString(), Long.class));
        } catch (final Exception e) {
            return Optional.empty();
        }
    }

}


