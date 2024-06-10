package bg.softuni.carDealer.models.entities;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    private String make;

    @Basic
    private String model;

    @Column(name = "travelled_distance")
    private BigInteger travelledDistance;

    @ManyToMany
    @JoinTable(name = "parts_cars",
            joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "part_id", referencedColumnName = "id"))

    private Set<Part> parts;

    private Car() {
        this.parts = new HashSet<>();
    }

    public void addPart(Part part) {
        if (parts.contains(part)) {
            throw new RuntimeException("This part has already been added.");
        }

        this.parts.add(part);
    }

    public void addParts(Set<Part> partList) {
        partList.forEach(this::addPart);
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setTravelledDistance(BigInteger travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && Objects.equals(make, car.make) && Objects.equals(model, car.model)
                && Objects.equals(travelledDistance, car.travelledDistance) && Objects.equals(parts, car.parts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, make, model, travelledDistance, parts);
    }

    public Integer getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public BigInteger getTravelledDistance() {
        return travelledDistance;
    }

    public Set<Part> getParts() {
        return parts;
    }
}
