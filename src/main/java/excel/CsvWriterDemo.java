package excel;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lianghong
 * @date 2019/8/28
 */

public class CsvWriterDemo {

    private static final String OUT_PUT_PATH = "./result.csv";

    public static void writeToCSV(String outPutPath, List<String[]> dataList) {
        File file = new File(outPutPath);
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(file))) {
            csvWriter.writeAll(dataList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        List<String[]> data = Arrays.asList((new String[]{"Name", "Email", "Phone"}),
//                (new String[]{"Jack", "jack@gmail.com", "123-5678"}),
//                (new String[]{"Helen", "helen@gmail.com", "222-3456"}));
//
//        writeToCSV(OUT_PUT_PATH, data);

        User jack = User.builder()
                .name("Jack")
                .email("jack@gmail.com")
                .phone("123-5678")
                .build();
        User helen = User.builder()
                .name("Helen")
                .email("helen@gmail.com")
                .phone("222-3456")
                .build();
        User tom = User.builder()
                .name("Tom")
                .email("tom@gmail.com")
                .phone("333-4444")
                .build();
        writeObjectToCSV(OUT_PUT_PATH, Arrays.asList(jack, helen, tom));
    }

    public static void writeObjectToCSV(String outPutPath, List<Object> objectList) {
        List<String[]> dataList = objectList.stream().map(object -> {
            Gson gson = new Gson();
            JsonElement jsonElement = gson.toJsonTree(object);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            return jsonObject.keySet().stream()
                    .map(jsonObject::get)
                    .map(JsonElement::getAsString)
                    .collect(Collectors.toList())
                    .toArray(new String[0]);
        }).collect(Collectors.toList());
        writeToCSV(OUT_PUT_PATH, dataList);
    }
}
