package bg.softuni.carDealer.models.dtos;

import jakarta.xml.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarExportDtoWrapper implements Serializable {
    @XmlElement(name = "car")
    private List<CarExportDtoWithId> carExportDtoList;

    public CarExportDtoWrapper() {}

    public CarExportDtoWrapper(List<CarExportDtoWithId> carExportDtoList) {
        this.carExportDtoList = carExportDtoList;
    }
}
