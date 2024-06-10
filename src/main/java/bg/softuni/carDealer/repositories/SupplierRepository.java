package bg.softuni.carDealer.repositories;

import bg.softuni.carDealer.models.dtos.LocalSupplierDto;
import bg.softuni.carDealer.models.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    @Query("""
            SELECT new bg.softuni.carDealer.models.dtos.LocalSupplierDto(s.id, s.name, COUNT(*))
            From Part p
            RIGHT JOIN p.supplier s
            WHERE s.usesImportedParts = false
            GROUP BY s.id
            """)
    List<LocalSupplierDto> findLocalSuppliersAndCountOfTheirParts();
}
