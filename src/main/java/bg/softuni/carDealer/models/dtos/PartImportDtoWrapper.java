package bg.softuni.carDealer.models.dtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;
@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartImportDtoWrapper {
    @XmlElement(name = "part")
    private List<PartImportDto> partImportDtos;

    public List<PartImportDto> getPartImportDtos() {
        return partImportDtos;
    }
}
