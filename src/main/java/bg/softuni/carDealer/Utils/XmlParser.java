package bg.softuni.carDealer.Utils;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class XmlParser {
    public static  <T> T fromXmlFile(String filePath, Class<T> tClass) {
        try (FileReader fileReader = new FileReader(filePath)) {
            JAXBContext context = JAXBContext.newInstance(tClass);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(fileReader);
        } catch (IOException | JAXBException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static <T> void toXmlFile(String fileName, T wrapper) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(wrapper.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        File file = new File(fileName);
        marshaller.marshal(wrapper, file);
    }
}
