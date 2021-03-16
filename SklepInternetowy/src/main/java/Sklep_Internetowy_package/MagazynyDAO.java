package Sklep_Internetowy_package;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;


@Repository
public class MagazynyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;



    public MagazynyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Magazyn> list(){
        String sql = "SELECT * FROM Magazyny";
        List<Magazyn> MagazynyList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Magazyn.class));
        return MagazynyList;
    }

    public void save(Magazyn magazyn){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("magazyny").usingColumns("magazyn_id", "powierzchnia", "miasto", "ulica", "numer");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(magazyn);
        insertActor.execute(param);
    }


    public Magazyn get(int magazyn_id){
        Object[] args = {magazyn_id};
        String sql = "SELECT * FROM MAGAZYNY WHERE magazyn_id = " + args[0];
        Magazyn magazyn = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Magazyn.class));
        return magazyn;
    }


    public void update(Magazyn magazyn){
        String sql = "UPDATE MAGAZYNY SET magazyn_id=:magazyn_id, powierzchnia=:powierzchnia, miasto=:miasto, ulica=:ulica, numer=:numer WHERE magazyn_id=:magazyn_id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(magazyn);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id){
        String sql = "DELETE FROM MAGAZYNY WHERE magazyn_id = " + String.valueOf(id);
        jdbcTemplate.update(sql);
    }



}
