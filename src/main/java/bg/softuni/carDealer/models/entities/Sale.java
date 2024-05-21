package bg.softuni.carDealer.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Car car;

    @ManyToOne
    private Customer customer;

    @Column(name = "discount_percentage")
    private Integer discountPercentage;

    public Sale(Car car, Customer customer, Integer discountPercentage) {
        this.car = car;
        this.customer = customer;
        this.discountPercentage = discountPercentage;
    }

}
