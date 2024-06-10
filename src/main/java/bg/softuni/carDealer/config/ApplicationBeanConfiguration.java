package bg.softuni.carDealer.config;

import bg.softuni.carDealer.models.dtos.CarExportDto;
import bg.softuni.carDealer.models.dtos.SaleDtoWithCarPrice;
import bg.softuni.carDealer.models.dtos.SaleExportDto;
import bg.softuni.carDealer.models.dtos.SupplierImportDto;
import bg.softuni.carDealer.models.entities.Sale;
import bg.softuni.carDealer.models.entities.Supplier;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<SupplierImportDto, Supplier>() {
            @Override
            protected void configure() {
                map().setUsesImportedParts(source.getImporter());
            }
        });

        modelMapper.addConverter(new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(MappingContext<String, LocalDateTime> context) {
                String source = context.getSource();
                return LocalDateTime.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
                //uuuu-MM-dd'T'HH:mm:ss
            }
        });

        modelMapper.addConverter(new Converter<LocalDateTime, String>() {
            @Override
            public String convert(MappingContext<LocalDateTime, String> context) {
                LocalDateTime source = context.getSource();
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss");
                return source.format(dateTimeFormatter);
            }
        });

        return modelMapper;
    }
}
