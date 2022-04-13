package ru.learnup.task23.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.task23.models.BookWarehouse;

import java.util.List;

@Repository
public interface BookWarehouseRepository extends JpaRepository<BookWarehouse, Long> {

    BookWarehouse save(BookWarehouse bookWarehouse);

    List<BookWarehouse> findAllBy(Long id);

    List<BookWarehouse> deleteBy(Long id);
}
