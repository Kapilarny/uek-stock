package pl.jkanclerz.stock.productcatalog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.UUID;

@SpringBootTest
public class ImageStorageTest {

    @Autowired
    CrudImageStorage crudImageStorage;

    @Test
    public void canStoreImage() {
        UUID id = UUID.randomUUID();
        Image i = new Image(id, "xd", BigDecimal.ONE, Arrays.asList("1234", "xd"), "file.png");

        Image loaded = crudImageStorage.findById(id.toString()).get();
    }

}
