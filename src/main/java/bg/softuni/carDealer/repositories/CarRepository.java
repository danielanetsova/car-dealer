package bg.softuni.carDealer.repositories;

import bg.softuni.carDealer.models.entities.Car;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    @Transactional
    @Query("FROM Car c left join fetch c.parts where c.id = :id")
    Car findCarWithContainedParts(int id);
}
