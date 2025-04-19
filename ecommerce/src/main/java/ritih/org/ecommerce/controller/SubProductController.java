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

import ritih.org.ecommerce.entity.SubProduct;
import ritih.org.ecommerce.repository.SubProductRepository;

@RestController
@RequestMapping("/subproducts")
public class SubProductController {

    @Autowired
    private SubProductRepository subProductRepo;

    @GetMapping
    public Iterable<SubProduct> getAll() {
        return subProductRepo.findAll();
    }

    @PostMapping	
    public SubProduct create(@RequestBody SubProduct subProduct) {
        return subProductRepo.save(subProduct);
    }

    @PutMapping("/{id}")
    public SubProduct update(@PathVariable Long id, @RequestBody SubProduct updated) {
        SubProduct existing = subProductRepo.findById(id).orElseThrow();
        existing.setName(updated.getName());
        return subProductRepo.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        subProductRepo.deleteById(id);
    }
}
