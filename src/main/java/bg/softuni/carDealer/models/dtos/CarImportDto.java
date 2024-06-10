package bg.softuni.carDealer.models.dtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarImportDto implements Serializable {
    private String make;

    private String model;

    @XmlElement(name = "travelled-distance")
    private Double travelledDistance;

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Double getTravelledDistance() {
        return travelledDistance;
    }
}
