package bg.softuni.carDealer;

import bg.softuni.carDealer.models.entities.Car;
import bg.softuni.carDealer.services.CarService;
import bg.softuni.carDealer.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    private final SeedService seedService;
    @Autowired
    public Runner(SeedService seedService) {
        this.seedService = seedService;
    }

    @Override
    public void run(String... args) throws Exception {
//        seedService.seedAll("xml");



    }

    
}
