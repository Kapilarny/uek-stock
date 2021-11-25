package pl.jkanclerz.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.jkanclerz.stock.productcatalog.ImageStorage;
import pl.jkanclerz.stock.productcatalog.ProductCatalogFacade;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public ProductCatalogFacade productCatalogFacade(ImageStorage imageStorage) {
        return new ProductCatalogFacade();
    }

    @Bean
    public ImageStorage imageStorage() {
        return new ImageStorage();
    }
}
