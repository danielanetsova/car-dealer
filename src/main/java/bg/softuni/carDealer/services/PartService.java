package bg.softuni.carDealer.services;

import bg.softuni.carDealer.models.entities.Part;
import bg.softuni.carDealer.repositories.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PartService {
    private final PartRepository partRepository;

    @Autowired
    public PartService(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    public boolean isDataSeeded() {
        return this.partRepository.count() > 0;
    }

    public void savePart(Part part) {
        this.partRepository.save(part);
    }

    public Set<Part> getRandomParts() {
        Set<Part> parts = new HashSet<>();
        int randomIterations = new Random().nextInt(3, 6);

        for (int i = 0; i < randomIterations; i++) {
            Part randomPart = getRandomPart();
            if (!parts.contains(randomPart)) {
                parts.add(randomPart);
            } else {
                i--;
            }
        }
        return parts;
    }

    private Part getRandomPart() {
        // The count of parts in the database is 131 and because nextInt() bound is exclusive 132 is put. 
        int randomId = new Random().nextInt(1, 132);
        Optional<Part> byId = this.partRepository.findById(randomId);
        return byId.orElse(null);
    }
}
