package bg.softuni.carDealer.services;

import bg.softuni.carDealer.models.entities.Car;
import bg.softuni.carDealer.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public boolean isDataSeeded() {
        return this.carRepository.count() > 0;
    }

    public void saveCar(Car car) {
        this.carRepository.saveAndFlush(car);
    }

    public Car getRandomCar() {
        int randomId = new Random().nextInt(1, 359);
        Optional<Car> byId = this.carRepository.findById(randomId);
        return carRepository.findCarWithContainedParts(randomId);
    }

    public List<Car> getCarsFromMakeToyota()  {
        return carRepository.findCarByMakeOrderByModelAscTravelledDistanceDesc("Toyota");
    }

    public List<Car> getAllCarsWithTheirParts() {
        return carRepository.findAllCarsWithTheirParts();
    }
}
