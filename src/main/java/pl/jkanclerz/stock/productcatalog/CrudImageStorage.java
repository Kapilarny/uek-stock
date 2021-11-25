package pl.jkanclerz.stock.productcatalog;

import org.springframework.data.repository.CrudRepository;

public interface CrudImageStorage extends CrudRepository<Image, String> {
}
