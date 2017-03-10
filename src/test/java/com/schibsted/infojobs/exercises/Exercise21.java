package com.schibsted.infojobs.exercises;

import com.schibsted.infojobs.model.Candidate;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise21 {

    private static DriverManagerDataSource DATA_SOURCE;
    private static JdbcTemplate JDBCTEMPLATE;

    public static List<Candidate> beforeJava8() {
        return JDBCTEMPLATE.query("select * from candidate", new RowMapper<Candidate>() {
            @Override
            public Candidate mapRow(ResultSet rs, int i) throws SQLException {
                return createCandidate(rs, i);
            }
        });
    }

    public static List<Candidate> withJava8() {
        return null;
    }
    private static Candidate createCandidate(ResultSet rs, int i) throws SQLException {
        return new Candidate(rs.getString("id"), rs.getString("name"), rs.getInt("age"), Collections.emptyList());
    }

    @Test
    public void exercise21() throws Exception {
        assertThat(withJava8()).isEqualTo(beforeJava8());
    }

    @Before
    public void setUp() throws Exception {
        DATA_SOURCE = new DriverManagerDataSource();
        DATA_SOURCE.setDriverClassName("org.h2.Driver");
        DATA_SOURCE.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        DATA_SOURCE.setUsername("");
        DATA_SOURCE.setPassword("");

        JDBCTEMPLATE = new JdbcTemplate(DATA_SOURCE);
        JDBCTEMPLATE.execute("create table candidate(id char(4) primary key, name varchar(200), age int not null)");
        JDBCTEMPLATE.execute("insert into candidate(id, name, age) values('0001', 'Pepe', 40)");
        JDBCTEMPLATE.execute("insert into candidate(id, name, age) values('0002', 'Manola', 41)");
        JDBCTEMPLATE.execute("insert into candidate(id, name, age) values('0003', 'Conchita', 39)");
    }

}
