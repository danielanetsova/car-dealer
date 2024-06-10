package bg.softuni.carDealer.services;

import bg.softuni.carDealer.Utils.Constants;
import bg.softuni.carDealer.Utils.JsonParser;
import bg.softuni.carDealer.Utils.XmlParser;
import bg.softuni.carDealer.models.dtos.*;
import bg.softuni.carDealer.models.entities.Car;
import bg.softuni.carDealer.models.entities.Customer;
import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class ExportService {
    private final CustomerService customerService;
    private final CarService carService;
    private final SupplierService supplierService;
    private final SaleService saleService;
    private final ModelMapper modelMapper;

    @Autowired
    public ExportService(CustomerService customerService, CarService carService,
                         SupplierService supplierService, SaleService saleService, ModelMapper modelMapper) {
        this.customerService = customerService;
        this.carService = carService;
        this.supplierService = supplierService;
        this.saleService = saleService;
        this.modelMapper = modelMapper;
    }

    public void exportAllReturnedDataAsXmlAndAsJson() {
        try {
            exportCustomersOrderedByBirthdate();
            exportCarsFromMakeToyota();
            exportLocalSuppliers();
            exportCarsWithTheirListOfParts();
            exportTotalSalesByCustomer();
            exportAllSales();
        } catch (JAXBException e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    private void exportCustomersOrderedByBirthdate() throws JAXBException {
        List<Customer> customers = this.customerService.getAllCustomersSortedByBirthDate();

        List<CustomerExportDto> customerDtoList = customers
                .stream()
                .map(customer -> modelMapper.map(customer, CustomerExportDto.class))
                .toList();

        CustomerExportDtoWrapper customerExportDtoWrapper = new CustomerExportDtoWrapper(customerDtoList);

        exportAsJsonAndAsXml(Constants.CUSTOMERS_ORDERED_BY_BIRTH_DATE_JSON_FILE_PATH,
                Constants.CUSTOMERS_ORDERED_BY_BIRTH_DATE_XML_FILE_PATH,
                customerDtoList, customerExportDtoWrapper);
    }

    private void exportCarsFromMakeToyota() throws JAXBException {
        List<Car> cars = this.carService.getCarsFromMakeToyota();

        List<CarExportDtoWithId> carsFromMakeToyotaDtoList = cars
                .stream()
                .map(car -> modelMapper.map(car, CarExportDtoWithId.class))
                .toList();

        CarExportDtoWrapper carExportDtoWrapper = new CarExportDtoWrapper(carsFromMakeToyotaDtoList);

        exportAsJsonAndAsXml(Constants.CARS_FROM_MAKE_TOYOTA_JSON_FILE_PATH,
                Constants.CARS_FROM_MAKE_TOYOTA_XML_FILE_PATH, carsFromMakeToyotaDtoList, carExportDtoWrapper);
    }

    private void exportLocalSuppliers() throws JAXBException {
        List<LocalSupplierDto> localSuppliers = this.supplierService.getLocalSuppliers();

        LocalSupplierDtoWrapper supplierDtoWrapper = new LocalSupplierDtoWrapper(localSuppliers);

        exportAsJsonAndAsXml(Constants.LOCAL_SUPPLIERS_JSON_FILE_PATH, Constants.LOCAL_SUPPLIERS_XML_FILE_PATH,
                localSuppliers, supplierDtoWrapper);
    }

    private void exportCarsWithTheirListOfParts() throws JAXBException {
        List<Car> cars = carService.getAllCarsWithTheirParts();

        List<CarWithListOfPartsDto> carDtoList = cars
                .stream()
                .map(car -> modelMapper.map(car, CarWithListOfPartsDto.class))
                .map(CarWithListOfPartsDto::carWithListOfPartsDto)
                .toList();

        CarsWithTheirListOfPartsDtoWrapper wrapper = new CarsWithTheirListOfPartsDtoWrapper(carDtoList);

        exportAsJsonAndAsXml(Constants.CARS_WITH_THEIR_LIST_OF_PARTS_JSON_FILE_PATH,
                Constants.CARS_WITH_THEIR_LIST_OF_PARTS_XML_FILE_PATH, carDtoList, wrapper);
    }

    private void exportTotalSalesByCustomer() throws JAXBException {
        List<TotalSalesByCustomerDto> customerDtoList = this.saleService.getCountOfCarsBoughtAndMoneySpentByCustomers();

        TotalSalesByCustomerDtoWrapper wrapper = new TotalSalesByCustomerDtoWrapper(customerDtoList);

        exportAsJsonAndAsXml(Constants.TOTAL_SALES_BY_CUSTOMER_JSON_FILE_PATH,
                Constants.TOTAL_SALES_BY_CUSTOMER_XML_FILE_PATH,
                customerDtoList, wrapper);
    }

    private void exportAllSales() throws JAXBException {
        List<SaleDtoWithCarPrice> allSales = this.saleService.getAllSales();

        List<SaleExportDto> saleDtoList = allSales
                .stream()
                .map(SaleDtoWithCarPrice::mapToSaleExportDto)
                .toList();

        SaleExportDtoWrapper wrapper = new SaleExportDtoWrapper(saleDtoList);

        exportAsJsonAndAsXml(Constants.SALES_WITH_APPLIED_DISCOUNT_JSON_FILE_PATH,
                Constants.SALES_WITH_APPLIED_DISCOUNT_XML_FILE_PATH,
                saleDtoList, wrapper);
    }

    private <D, W> void exportAsJsonAndAsXml(String jsonPath, String xmlPath, List<D> dtoList, W wrapper)
            throws JAXBException {

        File jsonFile = new File(jsonPath);
        File xmlFile = new File(xmlPath);

        if (jsonFile.length() == 0) {
            JsonParser.toJsonFile(jsonPath, dtoList);
        }

        if (xmlFile.length() == 0) {
            XmlParser.toXmlFile(xmlPath, wrapper);
        }
    }
}
