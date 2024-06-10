package bg.softuni.carDealer.models.dtos;

import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class LocalSupplierDto implements Serializable {
    @SerializedName(value = "Id")
    @XmlAttribute
    private Integer id;

    @SerializedName(value = "Name")
    @XmlAttribute
    private String name;

    @SerializedName(value = "PartsCount")
    @XmlAttribute(name = "parts-count")
    private Long partsCount;

    public LocalSupplierDto() {}

    public LocalSupplierDto(Integer id, String name, Long partsCount) {
        this.id = id;
        this.name = name;
        this.partsCount = partsCount;
    }
}
