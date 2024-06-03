package bg.softuni.carDealer.models.dtos;

import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerExportDto implements Serializable {

    @SerializedName(value = "Id")
    private Integer id;

    @SerializedName(value = "Name")
    private String name;

    @SerializedName(value = "BirthDate")
    @XmlElement(name = "birth-date")
    private String birthDate;

    @SerializedName("IsYoungDriver")
    @XmlElement(name = "is-young-driver")
    private Boolean isYoungDriver;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setYoungDriver(Boolean youngDriver) {
        isYoungDriver = youngDriver;
    }
}
