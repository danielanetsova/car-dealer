package bg.softuni.carDealer.models.dtos;

import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.math.BigInteger;
@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarExportDtoWithId  {

    @SerializedName(value = "Id")
    @XmlAttribute
    private Integer id;

    @SerializedName("Make")
    @XmlAttribute
    private String make;

    @SerializedName(value = "Model")
    @XmlAttribute
    private String model;

    @SerializedName(value = "TravelledDistance")
    @XmlAttribute(name = "travelled-distance")
    private BigInteger travelledDistance;

    public CarExportDtoWithId() {}

    public void setId(Integer id) {
        this.id = id;
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
