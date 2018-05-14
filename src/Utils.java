import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<Car> parseCarsFromFile(Path p){
        List<Car> carList = new ArrayList<>();
        try{
            Car car;
        for(String line : Files.readAllLines(p)){
            String[] elements = line.split(":");
            car = new Car(elements[0],
                    elements[1],
                    elements[2],
                    Integer.parseInt(elements[3]),
                    Integer.parseInt(elements[4]),
                    Integer.parseInt(elements[5]),
                    Integer.parseInt(elements[6]));
            carList.add(car);

        }

        } catch (IOException e){
            e.printStackTrace();
        }
        return carList;
    }

    public static void saveCarsToFile(Path path, List<Car> cars){
        String[] elementsArray = new String[7];
        StringBuilder builder;
        List<String> lines = new ArrayList<>();

        for (Car car : cars) {
            builder = new StringBuilder();
            elementsArray[0] = car.getBrand() + ":";
            elementsArray[1] = car.getModel() + ":";
            elementsArray[2] = car.getFuelType() + ":";
            elementsArray[3] = car.getCapacityEngine() + ":";
            elementsArray[4] = car.getNumberOfKilometers() + ":";
            elementsArray[5] = car.getProduceYear() + ":";
            elementsArray[6] = car.getRentStatus() + "";

            for (String s : elementsArray) {
                builder.append(s);
            }
            builder.append("\n");
            lines.add(builder.toString());
        }

        try {
            Files.write(path, lines, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
