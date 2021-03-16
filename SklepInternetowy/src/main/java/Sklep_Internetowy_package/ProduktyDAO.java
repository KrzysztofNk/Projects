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
public class ProduktyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;



    public ProduktyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Produkt> list(){
        String sql = "SELECT * FROM Produkty";
        List<Produkt> ProduktyList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Produkt.class));
        return ProduktyList;
    }


    public void save(Produkt produkt){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Produkty").usingColumns("nazwa","opis","ilosc","magazyn_id");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(produkt);
        insertActor.execute(param);
    }


    public Produkt get(int produkt_id){
        Object[] args = {produkt_id};
        String sql = "SELECT * FROM PRODUKTY WHERE produkt_id = " + args[0];
        Produkt produkt = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Produkt.class));
        return produkt;
    }


    public void update(Produkt produkt){
        String sql = "UPDATE PRODUKTY SET nazwa=:nazwa, opis=:opis, ilosc=:ilosc, magazyn_id=:magazyn_id WHERE produkt_id=:produkt_id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(produkt);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id){
        String sql = "DELETE FROM PRODUKTY WHERE produkt_id = " + String.valueOf(id);
        jdbcTemplate.update(sql);
    }



}
