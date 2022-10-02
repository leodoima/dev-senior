package br.com.devsenior.repositories;

import br.com.devsenior.models.SalesItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface SalesItemRepository extends JpaRepository<SalesItem, UUID> {

    @Query("SELECT sum(amount * unitaryValue) FROM SalesItem WHERE salesOrder = :id AND product = 'SERVICE'")
    public double sumServiceInOrder(@Param("id") UUID id);

    @Query("SELECT sum(amount * unitaryValue) FROM SalesItem WHERE salesOrder = :id AND product = 'PRODUCT'")
    public double sumProductInOrder(@Param("id") UUID id);
}
