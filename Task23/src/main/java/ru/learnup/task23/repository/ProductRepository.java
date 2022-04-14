package ru.learnup.task23.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.task23.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
