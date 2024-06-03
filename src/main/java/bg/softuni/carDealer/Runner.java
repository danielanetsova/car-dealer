package bg.softuni.carDealer;

import bg.softuni.carDealer.models.entities.Car;
import bg.softuni.carDealer.services.CarService;
import bg.softuni.carDealer.services.ExportService;
import bg.softuni.carDealer.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    private final SeedService seedService;
    private final ExportService exportService;

    @Autowired
    public Runner(SeedService seedService, ExportService exportService) {
        this.seedService = seedService;
        this.exportService = exportService;
    }

    @Override
    public void run(String... args) throws Exception {
//        seedService.seedAll("xml");
        exportService.exportCustomersOrderedByBirthdate();
    }

    
}
