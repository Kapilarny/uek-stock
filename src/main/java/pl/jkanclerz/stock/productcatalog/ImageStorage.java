package pl.jkanclerz.stock.productcatalog;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ImageStorage {
    Map<String, Image> images;

    public ImageStorage() {
        this.images = new HashMap<>();
    }

    public void save(Image image) {
        this.images.put(image.getId(), image);
    }

    public Optional<Image> load(String id) {
        return Optional.ofNullable(images.get(id));
    }
}
