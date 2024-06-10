package bg.softuni.carDealer.repositories;

import bg.softuni.carDealer.models.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query("FROM Car c left join fetch c.parts where c.id = :id")
    Car findCarWithContainedParts(int id);

    List<Car> findCarByMakeOrderByModelAscTravelledDistanceDesc(String make);

    @Query("FROM Car c LEFT JOIN FETCH c.parts")
    List<Car> findAllCarsWithTheirParts();
}
