package bg.softuni.carDealer.services;

import bg.softuni.carDealer.Utils.Constants;
import bg.softuni.carDealer.Utils.JsonParser;
import bg.softuni.carDealer.Utils.XmlParser;
import bg.softuni.carDealer.models.dtos.*;
import bg.softuni.carDealer.models.entities.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SeedService {

    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;
    private final ModelMapper modelMapper;

    @Autowired
    public SeedService(SupplierService supplierService, PartService partService, CarService carService,
                       CustomerService customerService, SaleService saleService, ModelMapper modelMapper) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
        this.modelMapper = modelMapper;
    }

    public void seedAll(String textFormat){
        seedSuppliers(textFormat);
        seedParts(textFormat);
        seedCars(textFormat);
        seedCustomers(textFormat);
        seedSales();
    };


    private void seedSuppliers(String textFormat){
        if(supplierService.isDataSeeded()) return;

        List<SupplierImportDto> supplierImportDtos = textFormat.equals("json") ?
                JsonParser.fromJsonFile(Constants.SUPPLIERS_JSON_INPUT_FILE_PATH, SupplierImportDto[].class) :
                XmlParser.fromXmlFile(Constants.SUPPLIERS_XML_INPUT_FILE_PATH, SupplierImportDtoWrapper.class)
                        .getSupplierImportDtos();

        for (SupplierImportDto supplierImportDto : supplierImportDtos) {
            Supplier supplier = this.modelMapper.map(supplierImportDto, Supplier.class);
            supplierService.saveSupplier(supplier);
        }
    };


    private void seedParts(String textFormat){
        if (this.partService.isDataSeeded()) return;

        List<PartImportDto> partImportDtos = textFormat.equals("json") ? JsonParser
                .fromJsonFile(Constants.PARTS_JSON_INPUT_FILE_PATH, PartImportDto[].class) :
                XmlParser.fromXmlFile(Constants.PARTS_XML_INPUT_FILE_PATH, PartImportDtoWrapper.class)
                        .getPartImportDtos();

        for (PartImportDto partImportDto : partImportDtos) {
            Part part = this.modelMapper.map(partImportDto, Part.class);
            part.setSupplier(supplierService.getRandomSupplier());
            partService.savePart(part);
        }
    };

    private void seedCars(String textFormat) {
        if (carService.isDataSeeded()) return;

        List<CarImportDto> carImportDtos = textFormat.equals("json") ? JsonParser
                .fromJsonFile(Constants.CARS_JSON_INPUT_FILE_PATH, CarImportDto[].class) :
                XmlParser.fromXmlFile(Constants.CARS_XML_INPUT_FILE_PATH, CarImportDtoWrapper.class).getCarImportDtos();

        for (CarImportDto carImportDto : carImportDtos) {
            Car car = this.modelMapper.map(carImportDto, Car.class);
            car.addParts(partService.getRandomParts());
            carService.saveCar(car);
        }
    }
    private void seedCustomers(String textFormat){
        if (this.customerService.isDataSeeded()) return;

        List<CustomerImportDto> customerImportDtos = textFormat.equals("json") ? JsonParser
                .fromJsonFile(Constants.CUSTOMERS_JSON_INPUT_FILE_PATH, CustomerImportDto[].class) :
                XmlParser.fromXmlFile(Constants.CUSTOMERS_XML_INPUT_FILE_PATH, CustomerImportDtoWrapper.class)
                        .getCustomerImportDtos();

        for (CustomerImportDto customerImportDto : customerImportDtos) {
            Customer customer = this.modelMapper.map(customerImportDto, Customer.class);
            customerService.saveCustomer(customer);
        }
    };

    private void seedSales() {
        if (this.saleService.isDataSeeded()) return;
        
        Set<Car> soldCars = new HashSet<>();

        for (int i = 0; i < 90; i++) {
            Car randomCar = getRandomCarWhichIsNotSold(soldCars);
            Customer randomCustomer = customerService.getRandomCustomer();
            int randomDiscountPercentage = saleService.getRandomDiscountPercentage();

            Sale sale = new Sale(randomCar, randomCustomer, randomDiscountPercentage);
            saleService.saveSale(sale);
        }
    }

    private Car getRandomCarWhichIsNotSold(Set<Car> soldCars) {
        Car randomCar = carService.getRandomCar();
        
        if (soldCars.contains(randomCar)) {
            randomCar = getRandomCarWhichIsNotSold(soldCars);
        }
        
        soldCars.add(randomCar);
        return randomCar;
    }
}
