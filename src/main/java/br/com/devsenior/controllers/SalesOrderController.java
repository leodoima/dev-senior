package br.com.devsenior.controllers;

import br.com.devsenior.models.SalesOrder;
import br.com.devsenior.repositories.SalesOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class SalesOrderController {

    @Autowired
    private SalesOrderRepository salesOrderRepository;

    @GetMapping
    public Page<SalesOrder> list(@RequestParam(value = "page", defaultValue = "0", required = false) int page) {
        return this.salesOrderRepository.findAll(PageRequest.of(page, 10));
    }

    @GetMapping("/{id}")
    public SalesOrder read(@PathVariable("id") UUID id) {

        Optional<SalesOrder> orderFind = this.salesOrderRepository.findById(id);

        return orderFind.orElse(null);
    }

    @PostMapping("/")
    public SalesOrder create(@RequestBody SalesOrder salesOrder) {
        return this.salesOrderRepository.save(salesOrder);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody SalesOrder salesOrder) {

        if (salesOrder.getId() == null) {
            return ResponseEntity.badRequest().body("Necessário informar a ID do pedido");
        }

        Optional<SalesOrder> findOrder = this.salesOrderRepository.findById(salesOrder.getId());

        if (findOrder.isEmpty()) {
            return ResponseEntity.badRequest().body("O pedido requisitado não existe no sistema");
        }

        if (!findOrder.get().isOrderActive()) {
            return ResponseEntity.badRequest().body("O pedido encontra-se fechado e não pode ser alterado");
        }

        SalesOrder alterOrder = this.salesOrderRepository.save(salesOrder);

        return ResponseEntity.ok(alterOrder);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody SalesOrder salesOrder) {

        if (salesOrder.getId() == null) {
            return ResponseEntity.badRequest().body("Necessário informar a ID do pedido");
        }

        boolean isOrderExists = this.salesOrderRepository.existsById(salesOrder.getId());

        if (!isOrderExists) {
            return ResponseEntity.badRequest().body("Pedido não encontrado no sistema");
        }

        this.salesOrderRepository.delete(salesOrder);
        return ResponseEntity.ok("");
    }
}

