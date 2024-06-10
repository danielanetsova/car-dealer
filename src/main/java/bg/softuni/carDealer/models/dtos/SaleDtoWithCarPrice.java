package bg.softuni.carDealer.models.dtos;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SaleDtoWithCarPrice {
    private String carMake;
    private String carModel;
    private BigInteger carTravelledDistance;
    private String customerName;
    private Integer discountPercentage;
    private BigDecimal price;
    private BigDecimal priceWithDiscount;

    public SaleDtoWithCarPrice(String carMake, String carModel, BigInteger carTravelledDistance,
                               String customerName, Integer discountPercentage, BigDecimal price, BigDecimal priceWithDiscount) {
        this.carMake = carMake;
        this.carModel = carModel;
        this.carTravelledDistance = carTravelledDistance;
        this.customerName = customerName;
        this.discountPercentage = discountPercentage;
        this.price = price;
        this.priceWithDiscount = priceWithDiscount;
    }

    public SaleExportDto mapToSaleExportDto() {
        return new SaleExportDto(new CarExportDto(this.carMake, this.carModel, this.carTravelledDistance),
                this.customerName,
                this.discountPercentage.toString() + "%",
                this.price, this.priceWithDiscount);
    }
}
