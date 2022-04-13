package ru.learnup.task23.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.task23.models.Buyers;

import java.util.List;

@Repository
public interface BuyersRepository extends JpaRepository<Buyers, Long> {

    Buyers save(Buyers buyers);

    List<Buyers> findAllBy(Long id);

    List<Buyers> deleteBy(Long id);
}
