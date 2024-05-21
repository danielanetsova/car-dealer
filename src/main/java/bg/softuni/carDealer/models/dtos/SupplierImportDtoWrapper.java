package bg.softuni.carDealer.models.dtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierImportDtoWrapper {
    @XmlElement(name = "supplier")
    private List<SupplierImportDto> supplierImportDtos;

    public List<SupplierImportDto> getSupplierImportDtos() {
        return supplierImportDtos;
    }
}
