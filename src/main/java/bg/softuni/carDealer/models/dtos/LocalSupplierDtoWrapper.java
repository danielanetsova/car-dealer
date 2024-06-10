package bg.softuni.carDealer.models.dtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class LocalSupplierDtoWrapper implements Serializable {
    @XmlElement(name = "customer")
    private List<LocalSupplierDto> localSupplierDtoList;

    public LocalSupplierDtoWrapper() {}

    public LocalSupplierDtoWrapper(List<LocalSupplierDto> localSupplierDtoList) {
        this.localSupplierDtoList = localSupplierDtoList;
    }
}
