package bg.softuni.carDealer.models.dtos;

import bg.softuni.carDealer.models.entities.Part;
import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.*;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarWithListOfPartsDto implements Serializable {

    @SerializedName(value = "Make")
    @XmlAttribute
    private String make;

    @SerializedName(value = "Model")
    @XmlAttribute
    private String model;

    @SerializedName(value = "TravelledDistance")
    @XmlAttribute(name = "travelled-distance")
    private BigInteger travelledDistance;

    @SerializedName(value = "parts")
    @XmlElement(name = "parts")
    private List<PartDto> partDtoList;

    public CarWithListOfPartsDto() {}

    public CarWithListOfPartsDto(String make, String model, BigInteger travelledDistance, List<PartDto> partDtoList) {
        this.make = make;
        this.model = model;
        this.travelledDistance = travelledDistance;
        this.partDtoList = partDtoList;
    }

    private transient Set<Part> parts;

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setTravelledDistance(BigInteger travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }

    public CarWithListOfPartsDto carWithListOfPartsDto() {
        return new CarWithListOfPartsDto(make, model, travelledDistance, toPartDtoList());
    }

    private List<PartDto> toPartDtoList() {
        return parts.stream().map(this::toPartDto).collect(Collectors.toList());
    }

    private PartDto toPartDto(Part part) {
        return new PartDto(part.getName(), part.getPrice());
    }

}
