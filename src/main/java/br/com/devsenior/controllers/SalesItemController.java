package br.com.devsenior.controllers;

import br.com.devsenior.models.SalesItem;
import br.com.devsenior.repositories.SalesItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/itens")
public class SalesItemController {

    @Autowired
    private SalesItemRepository salesItemRepository;

    @GetMapping
    public Page<SalesItem> list(@RequestParam(value = "page", defaultValue = "0", required = false) int page) {
        return this.salesItemRepository.findAll(PageRequest.of(page, 10));
    }

    @GetMapping("/{id}")
    public SalesItem read(@PathVariable("id") UUID id) {

        Optional<SalesItem> itemFind = this.salesItemRepository.findById(id);

        return itemFind.orElse(null);
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody SalesItem salesItem) {

        if (salesItem.getSalesOrder() == null) {
            return ResponseEntity.badRequest().body("O item precisa estar ligado a um pedido");
        }

        if (!salesItem.getSalesOrder().isOrderActive()) {
            return ResponseEntity.badRequest().body("Item não pode ser inserido em um pedido fechado");
        }

        return ResponseEntity.ok(this.salesItemRepository.save(salesItem));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody SalesItem salesItem) {

        Optional<SalesItem> findItem = this.salesItemRepository.findById(salesItem.getId());

        if (findItem.isEmpty()) {
            return ResponseEntity.badRequest().body("O produto requisitado não existe no sistema");
        }

        if (findItem.get().getSalesOrder().isOrderActive()) {
            return ResponseEntity.badRequest().body("O pedido de origem encontra-se fechado");
        }

        if (!salesItem.getSalesOrder().isOrderActive()) {
            return ResponseEntity.badRequest().body("O pedido de destino encontra-se fechado");
        }

        return ResponseEntity.ok(this.salesItemRepository.save(salesItem));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody SalesItem salesItem) {

        boolean isItemExists = this.salesItemRepository.existsById(salesItem.getId());

        if (!isItemExists) {
            return ResponseEntity.badRequest().body("O produto requisitado não existe no sistema");
        }

        if (!salesItem.getSalesOrder().isOrderActive()) {
            return ResponseEntity.badRequest().body("Item vinculado a pedido já fechado");
        }

        this.salesItemRepository.delete(salesItem);
        return ResponseEntity.ok("");
    }
}

