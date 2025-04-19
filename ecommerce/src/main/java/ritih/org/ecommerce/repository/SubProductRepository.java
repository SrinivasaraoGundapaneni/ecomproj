package ritih.org.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ritih.org.ecommerce.entity.SubProduct;

@Repository
public interface SubProductRepository extends CrudRepository<SubProduct, Long> {
}
