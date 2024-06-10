package bg.softuni.carDealer.models.dtos;

import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.math.BigDecimal;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)

public class TotalSalesByCustomerDto implements Serializable {
    @SerializedName(value = "FullName")
    @XmlAttribute(name = "full-name")
    private String fullName;

    @SerializedName(value = "BoughtCars")
    @XmlAttribute(name = "bought-cars")
    private Long boughtCars;

    @SerializedName(value = "SpentMoney")
    @XmlAttribute(name = "spent-money")
    private BigDecimal spentMoney;

    public TotalSalesByCustomerDto() {}

    public TotalSalesByCustomerDto(String fullName, Long boughtCars, BigDecimal spentMoney) {
        this.fullName = fullName;
        this.boughtCars = boughtCars;
        this.spentMoney = spentMoney;
    }
}
