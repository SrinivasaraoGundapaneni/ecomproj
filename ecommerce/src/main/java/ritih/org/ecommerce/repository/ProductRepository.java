package ritih.org.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ritih.org.ecommerce.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
