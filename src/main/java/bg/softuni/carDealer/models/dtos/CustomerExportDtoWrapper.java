package bg.softuni.carDealer.models.dtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerExportDtoWrapper {
    @XmlElement(name = "customer")
    private List<CustomerExportDto> customersExportDtos;

    public CustomerExportDtoWrapper() {}

    public CustomerExportDtoWrapper(List<CustomerExportDto> customersExportDtos) {
        this.customersExportDtos = customersExportDtos;
    }

    public void setCustomersExportDtos(List<CustomerExportDto> customersExportDtos) {
        this.customersExportDtos = customersExportDtos;
    }
}
