package bg.softuni.carDealer.models.dtos;

import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.math.BigInteger;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarExportDto implements Serializable {

    @SerializedName("Make")
    @XmlAttribute
    private String make;

    @SerializedName(value = "Model")
    @XmlAttribute
    private String model;

    @SerializedName(value = "TravelledDistance")
    @XmlAttribute(name = "travelled-distance")
    private BigInteger travelledDistance;

    public CarExportDto() {}

    public CarExportDto(String make, String model, BigInteger travelledDistance) {
        this.make = make;
        this.model = model;
        this.travelledDistance = travelledDistance;
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
}
