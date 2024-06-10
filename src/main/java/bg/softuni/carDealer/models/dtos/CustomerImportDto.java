package bg.softuni.carDealer.models.dtos;

import jakarta.xml.bind.annotation.*;

import java.io.Serializable;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerImportDto implements Serializable {
    @XmlAttribute
    private String name;

    @XmlElement(name = "birth-date")
    private String birthDate;

    @XmlElement(name = "is-young-driver")
    private Boolean isYoungDriver;

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Boolean getYoungDriver() {
        return isYoungDriver;
    }
}
