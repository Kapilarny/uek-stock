package pl.jkanclerz.stock;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.jkanclerz.stock.productcatalog.Image;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

@SpringBootTest
public class JbdcPlaygroundTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setUpDb() {
        jdbcTemplate.execute("DROP TABLE `product_catalog__products` IF EXISTS");

        jdbcTemplate.execute("CREATE TABLE `product_catalog__products` (" +
                "`id` varchar(100) NOT NULL, " +
                "`description` varchar(255), " +
                "PRIMARY KEY (id)" +
                ")");
    }

    @Test
    public void canCountProducts() {
        int productCount = jdbcTemplate.queryForObject(
                "select 1",
                Integer.class
        );

        assertEquals(1, productCount);
    }

    @Test
    public void canCountProductWithinDataSource() {
        int productCount = jdbcTemplate.queryForObject(
                "select count (*) from product_catalog__products",
                Integer.class
        );

        assertEquals(0, productCount);
    }

    @Test
    public void canSoreProduct() {
        String insertSql = "INSERT INTO `product_catalog__products` (`id`, `description`) " +
                "values " +
                "('123qwe', '123qwe description'), " +
                "('423qwe', '123qwe description') " +
                ";";

        jdbcTemplate.execute(insertSql);

        int productCount = jdbcTemplate.queryForObject(
                "select count (*) from product_catalog__products",
                Integer.class
        );

        assertEquals(2, productCount);
    }

    @Test
    public void postClassToDB() {
        UUID id = UUID.randomUUID();
        Image i = new Image(id, "xd", BigDecimal.ONE, Arrays.asList("1234", "xd"), "file.png");

        // MAPOWANIE KLASY

        jdbcTemplate.execute("CREATE TABLE `` (" +
                "`id` "  + id + " NOT NULL, " +
                "`title` " + i.getTitle() +
                "PRIMARY KEY (id)" +
                ")");
    }
}
