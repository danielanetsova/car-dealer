package bg.softuni.carDealer.models.dtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierImportDto implements Serializable {
    @XmlAttribute
    private String name;

    @XmlAttribute(name = "is-importer")
    private Boolean isImporter;

    public String getName() {
        return name;
    }

    public Boolean getImporter() {
        return isImporter;
    }
}
