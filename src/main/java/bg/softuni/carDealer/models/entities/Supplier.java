package bg.softuni.carDealer.models.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    private String name;

    @Column(name = "uses_imported_parts")
    private Boolean usesImportedParts;

    public Supplier() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setUsesImportedParts(Boolean usesImportedParts) {
        this.usesImportedParts = usesImportedParts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(id, supplier.id) && Objects.equals(name, supplier.name) && Objects.equals(usesImportedParts,
                supplier.usesImportedParts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, usesImportedParts);
    }
}
