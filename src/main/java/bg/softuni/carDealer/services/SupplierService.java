package bg.softuni.carDealer.services;

import bg.softuni.carDealer.models.entities.Supplier;
import bg.softuni.carDealer.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public boolean isDataSeeded() {
        return this.supplierRepository.count() > 0;
    }

    public void saveSupplier(Supplier supplier) {
        this.supplierRepository.saveAndFlush(supplier);
    }

    public Supplier getRandomSupplier() {
        // The count of suppliers in the database is 31 and because nextInt() bound is exclusive 32 is put.
        int randomId = new Random().nextInt(1, 32);
        Optional<Supplier> byId = this.supplierRepository.findById(randomId);
        return byId.orElse(null);
    }
}
