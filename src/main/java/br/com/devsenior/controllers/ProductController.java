package br.com.devsenior.controllers;

import br.com.devsenior.models.Product;
import br.com.devsenior.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public Page<Product> list(@RequestParam(value = "page", defaultValue = "0", required = false) int page) {
        return this.productRepository.findAll(PageRequest.of(page, 10));
    }

    @GetMapping("/{id}")
    public Product read(@PathVariable("id") UUID id) {

        Optional<Product> productFind = this.productRepository.findById(id);

        return productFind.orElse(null);
    }

    @PostMapping("/")
    public Product create(@RequestBody Product product) {
        return this.productRepository.save(product);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Product product) {

        Optional<Product> findProduct = this.productRepository.findById(product.getId());

        if (findProduct.isPresent()) {
            return ResponseEntity.ok(this.productRepository.save(product));
        }

        return ResponseEntity.badRequest().body("O produto requisitado não existe no sistema");
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Product product) {

        boolean isProductExists = this.productRepository.existsById(product.getId());

        if (!isProductExists) {
            return ResponseEntity.badRequest().body("O produto requisitado não existe no sistema");
        }


        this.productRepository.delete(product);
        return ResponseEntity.ok("");
    }
}
