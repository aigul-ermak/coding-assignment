import java.time.LocalDateTime;
import java.time.Month;
import java.util.Scanner;

public class Main {
    public static final String INVALID_CHOICE_MESSAGE = "Invalid choice. Please enter y, n, or q.";
    public static final String EXIT_MESSAGE = "Exiting the system. Goodbye!";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        LocalDateTime now = LocalDateTime.now();

        // test date for update
        //LocalDateTime now = LocalDateTime.of(LocalDateTime.now().getYear(), Month.JANUARY, 1, 1, 0);

        if (now.getMonth() == Month.JANUARY && now.getDayOfMonth() == 1 && now.getHour() == 1 && now.getMinute() == 0) {
            System.out.println("Turning off all devices for the yearly update.");
            light.turnOffForUpdate();
            fan.turnOffForUpdate();
            ac.turnOffForUpdate();
        } else {

            System.out.println("Hi! You are in the Smart Home Appliance Control System!");

            while (true) {
                System.out.println("What do you want to choose: Light, Fan, or Air Conditioner?");

                System.out.println("Enter L for Light, F for Fan, A for Air Conditioner, or Q to quit");

                String choice = sc.nextLine().toUpperCase();

                if (choice.equals("Q")) {
                    System.out.println(EXIT_MESSAGE);
                    break;
                }

                switch (choice) {
                    case "L" -> handleToggleAppliance(sc, light, "Light", light.getState().toString());
                    case "F" -> handleToggleAppliance(sc, fan, "Fan", String.valueOf(fan.getSpeed()));
                    case "A" -> handleToggleAppliance(sc, ac, "Air Conditioner", ac.getState().toString());
                    default -> System.out.println("Invalid selection. Please enter L, F, or A.");
                }
            }
        }
        sc.close();
    }

    public static void checkForSystemUpdate(Light light, Fan fan, AirConditioner ac) {
        LocalDateTime now = LocalDateTime.now();

        // Check if it's January 1st and 1:00 AM local time
        if (now.getMonth() == Month.JANUARY && now.getDayOfMonth() == 1 && now.getHour() == 1 && now.getMinute() == 0) {
            System.out.println("System Update: Turning off all devices for the yearly update...");

            light.turnOffForUpdate();
            fan.turnOffForUpdate();
            ac.turnOffForUpdate();
        } else {
            System.out.println("System Update: No update needed at this time.");
        }
    }

    public static <T> void handleToggleAppliance(Scanner sc, T appliance, String applianceName, String currentState) {
        label:
        while (true) {
            System.out.println("Would you like to toggle the " + applianceName.toLowerCase() + "? (y for yes, n for no, q to quit)");
            String toggleChoice = sc.nextLine().toLowerCase();

            switch (toggleChoice) {
                case "y":
                    if (appliance instanceof Light) {
                        ((Light) appliance).toggle();
                    } else if (appliance instanceof Fan) {
                        ((Fan) appliance).toggle();
                    } else if (appliance instanceof AirConditioner) {
                        ((AirConditioner) appliance).toggle();
                    }
                    break;
                case "n":
                    break label;
                case "q":
                    System.out.println(EXIT_MESSAGE);
                    System.exit(0);
                default:
                    System.out.println(Main.INVALID_CHOICE_MESSAGE);
                    break;
            }
        }
    }
}

