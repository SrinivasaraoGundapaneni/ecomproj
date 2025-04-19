package ritih.org.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ritih.org.ecommerce.entity.Product;
import ritih.org.ecommerce.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepo;

    @GetMapping
    public Iterable<Product> getAll() {
        return productRepo.findAll();
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productRepo.save(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product updated) {
        Product existing = productRepo.findById(id).orElseThrow();
        existing.setName(updated.getName());
        return productRepo.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productRepo.deleteById(id);
    }
}
