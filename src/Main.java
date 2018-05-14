import javax.sound.midi.Patch;
import javax.xml.bind.SchemaOutputResolver;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    private Scanner scanner;
    private List<Car> carList;

    public Main(){
        scanner = new Scanner(System.in);
        carList = Utils.parseCarsFromFile(Paths.get("cars.txt"));
        start();
    }


    private void start(){
        System.out.println("Witaj w mojej wypożyczalni!");

        String command;
        do{
            System.out.println("1 - Dodawanie samochodu");
            System.out.println("2 - Wypożyczenie samochodu");
            System.out.println("3 - Oddawanie samochodu");
            System.out.println("4 - Wyświetl wolne pozycje");

            System.out.println("Wpisz polecenie: ");
            command = scanner.nextLine();
            parseChoice(command);

        }while (!command.equals("exit"));
    }

    private void parseChoice(String command) {
        switch (command){
            case "4": {
                showFreeCars();
                break;
            }

            case "1": {
                addCars();
                break;
            }

            case "2": {
                rentCar();
                break;
            }

            case "3": {
                bringBackCar();
                break;
            }

            case "exit": {
                Utils.saveCarsToFile(Paths.get("cars.txt"), carList);
                break;
            }

            default: {
                System.out.println("Nie ma takiej komendy!");
            }
        }
    }

    private void bringBackCar() {
        System.out.println("Podaj markę samochodu, który chcesz zwrócić: ");
        String brand = scanner.nextLine();

        for (Car car : carList) {
            if(car.getBrand().equalsIgnoreCase(brand) && car.getRentStatus() == 1){
                car.setRentStatus(0);
                System.out.println("Dziękujemy za zwrócenie samochodu");
                return;
            }
        }
        System.out.println("Taki samochód nie jest wypożyczony lub nie istnieje!");
    }

    private void rentCar() {
        System.out.println("Podaj markę samochodu, który chcesz wypożyczyć: ");
        String brand = scanner.nextLine();

        for (Car car : carList){
            if(car.getBrand().equalsIgnoreCase(brand) && car.getRentStatus() == 0){
                car.setRentStatus(1);
                System.out.println("Wypożyczono samochód " + car.getBrand());
                System.out.println("Oddaj samochód gdy już nie bedzie potrzebny!");
                return;
            }
        }
        System.out.println("Nie mamy takiego samochodu na stanie!");
    }

    private void addCars() {
        System.out.println("Dodajesz nowy samochód!");
        String brand, model, fuelType;
        int capacityEngine, number0fKilometers, produceYear;

        System.out.print("Marka: ");
        brand = scanner.nextLine();

        for (Car car : carList) {
            if(car.getBrand().equalsIgnoreCase(brand)){
                System.out.println("Taki samochód już istnieje!");
                return;
            }
        }

        System.out.print("Model: ");
        model = scanner.nextLine();

        System.out.print("Rodzaj paliwa: ");
        fuelType = scanner.nextLine();

        System.out.print("Pojemność silnika: ");
        capacityEngine = Integer.parseInt(scanner.nextLine());

        System.out.print("Przebieg: ");
        number0fKilometers = Integer.parseInt(scanner.nextLine());

        System.out.print("Rok produkcji: ");
        produceYear = Integer.parseInt(scanner.nextLine());

        carList.add(new Car(brand, model, fuelType, capacityEngine, number0fKilometers, produceYear, 0));
        System.out.println("Dodano samochód " + brand);

    }

    private void showFreeCars() {
        for (Car car : carList) {
            if(car.getRentStatus() == 0){
                System.out.println("Wolna pozycja: " + car.getBrand());
            }

        }
    }


}
