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

import ritih.org.ecommerce.entity.Category;
import ritih.org.ecommerce.repository.CategoryRepository;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepo;

    @GetMapping
    public Iterable<Category> getAll() {
        return categoryRepo.findAll();
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return categoryRepo.save(category);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category updated) {
        Category existing = categoryRepo.findById(id).orElseThrow();
        existing.setName(updated.getName());
        return categoryRepo.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryRepo.deleteById(id);
    }
}
