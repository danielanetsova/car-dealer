package bg.softuni.carDealer.models.dtos;

import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.math.BigDecimal;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartDto implements Serializable {
    @SerializedName(value = "Name")
    @XmlAttribute
    private String name;

    @SerializedName(value = "Price")
    @XmlAttribute
    private BigDecimal price;

    public PartDto() {}

    public PartDto(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}
