package ru.learnup.task23.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.task23.models.BookWarehouse;
import ru.learnup.task23.models.Orders;

@Repository
public interface BookWarehouseRepository extends JpaRepository<BookWarehouse, Long> {

    BookWarehouse save(BookWarehouse bookWarehouse);

    Orders findAllById(Long id);

    void delete(Long id);
}