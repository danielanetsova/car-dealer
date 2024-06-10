package bg.softuni.carDealer.services;

import bg.softuni.carDealer.models.dtos.SaleDtoWithCarPrice;
import bg.softuni.carDealer.models.dtos.TotalSalesByCustomerDto;
import bg.softuni.carDealer.models.entities.Sale;
import bg.softuni.carDealer.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class SaleService {
    private final SaleRepository saleRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }


    public Boolean isDataSeeded() {
        return this.saleRepository.count() > 0;
    }

    public void saveSale(Sale sale) {
        this.saleRepository.save(sale);
    }

    public Integer getRandomDiscountPercentage() {
        List<Integer> discounts = Arrays.asList(0, 5, 10, 15, 20, 30, 40, 50);
        Random random = new Random();
        int randomIndexOfDiscountsList = random.nextInt(0, discounts.size());
        return discounts.get(randomIndexOfDiscountsList);
    }

    public List<TotalSalesByCustomerDto> getCountOfCarsBoughtAndMoneySpentByCustomers() {
        return saleRepository.findCountOfCarsBoughtAndMoneySpentByCustomers();
    }

    public List<SaleDtoWithCarPrice> getAllSales() {
        return this.saleRepository.findAllSales();
    }
}
