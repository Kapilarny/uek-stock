package pl.jkanclerz.stock.productcatalog;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ProductCatalogFacade {

    ImageStorage imageStorage;

    public ProductCatalogFacade() {
        this.imageStorage = new ImageStorage();
    }

    public String addPicture(String title, BigDecimal price, List<String> keywords, String filePath) {
        Image image = new Image(UUID.randomUUID(), title, price, keywords, filePath);
        imageStorage.save(image);
        return image.getId();
    }

    public boolean isProductExists(String id) {
        return imageStorage.load(id).isPresent();
    }
}
