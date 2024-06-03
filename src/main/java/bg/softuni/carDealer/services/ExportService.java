package bg.softuni.carDealer.services;

import bg.softuni.carDealer.Utils.Constants;
import bg.softuni.carDealer.Utils.JsonParser;
import bg.softuni.carDealer.Utils.XmlParser;
import bg.softuni.carDealer.models.dtos.CustomerExportDto;
import bg.softuni.carDealer.models.dtos.CustomerExportDtoWrapper;
import bg.softuni.carDealer.models.entities.Customer;
import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExportService {
    private final CustomerService customerService;
    private final ModelMapper modelMapper;
    @Autowired
    public ExportService(CustomerService customerService, ModelMapper modelMapper) {
        this.customerService = customerService;
        this.modelMapper = modelMapper;
    }

    public void exportCustomersOrderedByBirthdate() throws JAXBException {
        List<Customer> customers = this.customerService.getAllCustomersSortedByBirthDate();
        List<CustomerExportDto> customerDtos = new ArrayList<>();

        customers.forEach(customer -> customerDtos.add(modelMapper.map(customer, CustomerExportDto.class)));

//        for (Customer customer : customers) {
//            CustomerExportDto dto = modelMapper.map(customer, CustomerExportDto.class);
//            customerDtos.add(dto);
//        }

        CustomerExportDtoWrapper customerExportDtoWrapper = new CustomerExportDtoWrapper(customerDtos);

        File jsonFile = new File(Constants.CUSTOMERS_ORDERED_BY_BIRTH_DATE_JSON_FILE_PATH);
        File xmlFile = new File(Constants.CUSTOMERS_ORDERED_BY_BIRTH_DATE_XML_FILE_PATH);

        if (jsonFile.length() == 0) {
            JsonParser.toJsonFile(Constants.CUSTOMERS_ORDERED_BY_BIRTH_DATE_JSON_FILE_PATH, customerDtos);
        }

        if(xmlFile.length() == 0) {
            XmlParser.toXmlFile(Constants.CUSTOMERS_ORDERED_BY_BIRTH_DATE_XML_FILE_PATH, customerExportDtoWrapper);
        }

    }
}
