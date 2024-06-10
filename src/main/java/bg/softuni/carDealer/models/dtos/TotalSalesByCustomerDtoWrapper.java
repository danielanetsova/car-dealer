package bg.softuni.carDealer.models.dtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class TotalSalesByCustomerDtoWrapper implements Serializable {
    private List<TotalSalesByCustomerDto> list;

    public  TotalSalesByCustomerDtoWrapper() {}

    public TotalSalesByCustomerDtoWrapper(List<TotalSalesByCustomerDto> list) {
        this.list = list;
    }
}
