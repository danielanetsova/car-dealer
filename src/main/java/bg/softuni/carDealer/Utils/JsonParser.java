package bg.softuni.carDealer.Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonParser {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static <T> List<T> fromJsonFile(String filePath, Class<T[]> tClass) {
        try (FileReader fileReader = new FileReader(filePath)) {
            T[] result = GSON.fromJson(fileReader, tClass);
            return Arrays.stream(result).toList();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static <T> void toJsonFile(String filePath, List<T> listOfObjects) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            GSON.toJson(listOfObjects, fileWriter);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
