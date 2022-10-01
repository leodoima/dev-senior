package br.com.devsenior.controllers;

import br.com.devsenior.models.Product;
import br.com.devsenior.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final List<Product> products = new ArrayList<>();

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/{id}")
    public Product product(@PathVariable("id") Long id) {

        Optional<Product> productFind = this.productRepository.findById(id);

        return productFind.orElse(null);
    }

    @GetMapping("/list")
    public List<Product> list() {
        return this.productRepository.findAll();
    }

    @PostMapping("/")
    public Product newProduct(@RequestBody Product product) {
        return this.productRepository.save(product);
    }
}
