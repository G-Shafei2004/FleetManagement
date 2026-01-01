import java.util.ArrayList;
import java.util.Scanner;

public class FleetApp {

    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        FleetApp app = new FleetApp();
        app.run();
    }

    public void run() {
        while (true) {
            System.out.println("\nFleet Management System");
            System.out.println("1. Print all vehicles");
            System.out.println("2. Add new car");
            System.out.println("3. Add new bus");
            System.out.println("4. Show total insurance fees");
            System.out.println("5. Perform service for all vehicles");
            System.out.println("6. Quit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    printVehicles();
                    break;
                case 2:
                    addCar();
                    break;
                case 3:
                    addBus();
                    break;
                case 4:
                    showTotalInsurance();
                    break;
                case 5:
                    serviceAll();
                    break;
                case 6:
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void printVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the fleet");
        } else {
            for (Vehicle v : vehicles) {
                System.out.println(v);
            }
        }
    }

    private void addCar() {
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        System.out.print("Doors: ");
        int doors = scanner.nextInt();
        scanner.nextLine();

        vehicles.add(new Car(model, year, price, doors));
    }

    private void addBus() {
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        System.out.print("Passengers: ");
        int passengers = scanner.nextInt();
        scanner.nextLine();

        vehicles.add(new Bus(model, year, price, passengers));
    }

    private void showTotalInsurance() {
        double total = 0;
        for (Vehicle v : vehicles) {
            total += v.calculateInsuranceFee();
        }
        System.out.println("Total insurance fee: " + total);
    }

    private void serviceAll() {
        for (Vehicle v : vehicles) {
            if (v instanceof Servicable) {
                ((Servicable) v).performService();
            }
        }
    }
}
