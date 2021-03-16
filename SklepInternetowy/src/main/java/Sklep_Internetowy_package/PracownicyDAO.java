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
public class PracownicyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;



    public PracownicyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Pracownik> list(){
        String sql = "SELECT * FROM PRACOWNICY";
        List<Pracownik> PracownicyList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownik.class));
        return PracownicyList;
    }


    public void save(Pracownik pracownik){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Pracownicy").usingColumns("imie","nazwisko","email", "telefon","stanowisko","data_urodzenia", "pensja", "nr_konta", "magazyn_id");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
        insertActor.execute(param);
    }


    public Pracownik get(int PracownikId){
        Object[] args = {PracownikId};
        String sql = "SELECT * FROM PRACOWNICY WHERE Pracownik_id = " + args[0];
        Pracownik pracownik = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Pracownik.class));
        return pracownik;
    }


    public void update(Pracownik pracownik){
        String sql = "UPDATE PRACOWNICY SET imie=:imie, nazwisko=:nazwisko, email=:email,telefon=:telefon,stanowisko=:stanowisko,data_urodzenia=:data_urodzenia, pensja=:pensja, nr_konta=:nr_konta, magazyn_id=:magazyn_id WHERE Pracownik_id=:Pracownik_id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int PracownikId){
        String sql = "DELETE FROM PRACOWNICY WHERE Pracownik_id = " + String.valueOf(PracownikId);
        jdbcTemplate.update(sql);
    }
}
