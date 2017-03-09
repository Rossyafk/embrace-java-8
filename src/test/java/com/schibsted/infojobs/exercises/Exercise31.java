package com.schibsted.infojobs.exercises;

import com.schibsted.infojobs.model.Candidate;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise31 {

    public static List<Candidate> beforeJava8(JdbcTemplate jdbcTemplate) {
        return jdbcTemplate.query("select * from candidate", new RowMapper<Candidate>() {
            @Override
            public Candidate mapRow(ResultSet rs, int i) throws SQLException {
                return createCandidate(rs, i);
            }
        });
    }

    public static List<Candidate> withJava8(JdbcTemplate jdbcTemplate) {
        return jdbcTemplate.query("select * from candidate", Exercise31::createCandidate);
    }

    @Test
    public void exercise31() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("");
        dataSource.setPassword("");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute("create table candidate(id char(4) primary key, name varchar(200) not null, age int not null)");
        jdbcTemplate.execute("insert into candidate(id, name, age) values('0001', 'Pepe', 40)");
        jdbcTemplate.execute("insert into candidate(id, name, age) values('0002', 'Manola', 41)");
        jdbcTemplate.execute("insert into candidate(id, name, age) values('0003', 'Conchita', 39)");

        List<Candidate> withJava8 = withJava8(jdbcTemplate);
        List<Candidate> beforeJava8 = beforeJava8(jdbcTemplate);
        assertThat(withJava8).isEqualTo(beforeJava8);
    }

    private static Candidate createCandidate(ResultSet rs, int i) throws SQLException {
        return new Candidate(rs.getString("id"), rs.getString("name"), rs.getInt("age"), Collections.emptyList());
    }
}
