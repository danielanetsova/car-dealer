package bg.softuni.carDealer.models.dtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarImportDtoWrapper {
    @XmlElement(name = "car")
    private List<CarImportDto> carImportDtos;

    public List<CarImportDto> getCarImportDtos() {
        return carImportDtos;
    }
}
