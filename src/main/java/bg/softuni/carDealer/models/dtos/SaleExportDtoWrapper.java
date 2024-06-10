package bg.softuni.carDealer.models.dtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleExportDtoWrapper implements Serializable {
    @XmlElement(name = "sale")
    private List<SaleExportDto> saleExportDtoList;

    public SaleExportDtoWrapper() {}

    public SaleExportDtoWrapper(List<SaleExportDto> saleExportDtoList) {
        this.saleExportDtoList = saleExportDtoList;
    }
}
