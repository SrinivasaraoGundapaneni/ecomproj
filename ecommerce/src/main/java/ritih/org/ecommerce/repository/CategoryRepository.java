package ritih.org.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ritih.org.ecommerce.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
