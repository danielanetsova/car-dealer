package bg.softuni.carDealer.models.dtos;

import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.math.BigDecimal;

@XmlRootElement(name = "sale")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleExportDto implements Serializable {
    @XmlElement
    @SerializedName(value = "Car")
    private CarExportDto carDto;

    @SerializedName(value = "CustomerName")
    @XmlElement(name = "customer-name")
    private String customerName;

    @SerializedName(value = "Discount")
    @XmlElement(name = "discount")
    private String discountPercentage;

    @SerializedName(value = "Price")
    @XmlElement(name = "price")
    private BigDecimal price;

    @SerializedName("PriceWithDiscount")
    @XmlElement(name = "price-with-discount")
    private BigDecimal priceWithDiscount;

    public SaleExportDto() {}

    public SaleExportDto(CarExportDto carDto, String customerName, String discountPercentage,
                         BigDecimal price, BigDecimal priceWithDiscount) {
        this.carDto = carDto;
        this.customerName = customerName;
        this.discountPercentage = discountPercentage;
        this.price = price;
        this.priceWithDiscount = priceWithDiscount;
    }
}
