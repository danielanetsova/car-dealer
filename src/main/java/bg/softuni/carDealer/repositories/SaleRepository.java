package bg.softuni.carDealer.repositories;

import bg.softuni.carDealer.models.dtos.SaleDtoWithCarPrice;
import bg.softuni.carDealer.models.dtos.TotalSalesByCustomerDto;
import bg.softuni.carDealer.models.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {

    @Query("""
            SELECT new bg.softuni.carDealer.models.dtos.TotalSalesByCustomerDto(
            cu.name,
            COUNT(ca.id) AS bought_cars,
            SUM(
                (SELECT SUM(p.price)
                FROM Car c
                JOIN c.parts p
                GROUP BY c.id
                HAVING c.id = ca.id)) AS total_sum)
            FROM Sale s
            JOIN s.car ca
            JOIN s.customer cu
            GROUP BY cu.name
            ORDER BY total_sum DESC, bought_cars DESC
            """)
    public List<TotalSalesByCustomerDto> findCountOfCarsBoughtAndMoneySpentByCustomers();


    @Query("""
            SELECT new bg.softuni.carDealer.models.dtos.SaleDtoWithCarPrice(
                        ca.make, ca.model, ca.travelledDistance, cu.name, s.discountPercentage, SUM(p.price),
            			IF(cu.isYoungDriver = true,
            			((SUM(p.price) - s.discountPercentage / 100 * SUM(p.price)) - (SUM(p.price) - s.discountPercentage / 100 * SUM(p.price)) * 0.05),
            			(SUM(p.price) - s.discountPercentage / 100 * SUM(p.price))))
                        FROM Sale s
                        JOIN s.customer cu
                        JOIN s.car ca
                        JOIN ca.parts p
                        GROUP BY ca.id
            """)
    //Young drivers get an additional 5% off for the sale
    public List<SaleDtoWithCarPrice> findAllSales();
}
