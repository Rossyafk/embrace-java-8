package com.schibsted.infojobs.exercises;

import com.schibsted.infojobs.model.Candidate;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise32 {

    public static List<Candidate> beforeJava8(JdbcTemplate jdbcTemplate) {
        List<SelectionRow> rows = jdbcTemplate.query(createQuery(), new RowMapper<SelectionRow>() {
            @Override
            public SelectionRow mapRow(ResultSet rs, int i) throws SQLException {
                return createRow(rs, i);
            }
        });
        Map<String, Candidate.Builder> builderMap = new HashMap<>();
        for (SelectionRow row : rows) {
            Candidate.Builder builder = builderMap.get(row.candidateId);
            if (builder == null) {
                builder = Candidate.builder(row.candidateId, row.candidateName, row.candidateAge);
                builderMap.put(row.candidateId, builder);
            }
            builder.addNationality(row.nationalityName);
        }
        List<Candidate> candidates = new ArrayList<>();
        for (Map.Entry<String, Candidate.Builder> entry : builderMap.entrySet()) {
            candidates.add(entry.getValue().build());
        }
        return candidates;
    }

    public static List<Candidate> withJava8(JdbcTemplate jdbcTemplate) {
        return null; // TODO ...
    }

    @Test
    public void exercise31() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("");
        dataSource.setPassword("");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute("create table candidate(id char(4) primary key, name varchar(200), age int not null)");
        jdbcTemplate.execute("create table nationality(cand_id char(4), name varchar(100) not null, primary key (cand_id, name), "
            + "foreign key (cand_id) references candidate(id))");
        jdbcTemplate.execute("insert into candidate(id, name, age) values('0001', 'Pepe', 40)");
        jdbcTemplate.execute("insert into candidate(id, name, age) values('0002', 'Manola', 41)");
        jdbcTemplate.execute("insert into candidate(id, name, age) values('0003', 'Conchita', 39)");
        jdbcTemplate.execute("insert into nationality(cand_id, name) values('0001', 'spain')");
        jdbcTemplate.execute("insert into nationality(cand_id, name) values('0002', 'spain')");
        jdbcTemplate.execute("insert into nationality(cand_id, name) values('0002', 'france')");

        List<Candidate> withJava8 = withJava8(jdbcTemplate);
        List<Candidate> beforeJava8 = beforeJava8(jdbcTemplate);
        assertThat(withJava8).isEqualTo(beforeJava8);
    }

    private static String createQuery() {
        return new StringBuilder()
            .append("select c.id as c_id, c.name as c_name, c.age as c_age, n.name as n_name ")
            .append("from candidate c ")
            .append("left join nacionality n on c.id = n.cand_id")
            .toString();
    }

    private static SelectionRow createRow(ResultSet rs, int i) throws SQLException {
        return new SelectionRow(rs.getString("c_id"), rs.getString("c_name"), rs.getInt("c_age"), rs.getString("n_name"));
    }

    private static class SelectionRow {

        private final String candidateId;
        private final String candidateName;
        private final int candidateAge;
        private final String nationalityName;

        SelectionRow(String candidateId, String candidateName, int candidateAge, String nationalityName) {
            this.candidateId = candidateId;
            this.candidateName = candidateName;
            this.candidateAge = candidateAge;
            this.nationalityName = nationalityName;
        }
    }
}
