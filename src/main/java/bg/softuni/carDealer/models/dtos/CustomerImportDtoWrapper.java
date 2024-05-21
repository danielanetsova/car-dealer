package bg.softuni.carDealer.models.dtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerImportDtoWrapper {
    @XmlElement(name = "customer")
    List<CustomerImportDto> customerImportDtos;

    public List<CustomerImportDto> getCustomerImportDtos() {
        return customerImportDtos;
    }
}
