package bg.softuni.carDealer.models.dtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsWithTheirListOfPartsDtoWrapper implements Serializable {

    @XmlElement(name = "car")
    private List<CarWithListOfPartsDto> carsWithParts;

    public CarsWithTheirListOfPartsDtoWrapper() {}

    public CarsWithTheirListOfPartsDtoWrapper(List<CarWithListOfPartsDto> carsWithParts) {
        this.carsWithParts = carsWithParts;
    }
}
