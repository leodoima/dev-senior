package br.com.devsenior.repositories;

import br.com.devsenior.models.SalesItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SalesItemRepository extends JpaRepository<SalesItem, UUID> {
}
