import java.util.Scanner;

enum ApplianceState {
    ON, OFF
}

class Light {
    private ApplianceState state;

    public Light() {
        this.state = ApplianceState.OFF;
    }

    public void toggle() {


        if (this.state == ApplianceState.OFF) {
            this.state = ApplianceState.ON;

        } else {
            this.state = ApplianceState.OFF;

        }
        System.out.println("The light is now: " + this.state);


//        if (this.state == ApplianceState.OFF) {
//            this.state = ApplianceState.ON;
//            System.out.println("The light is now ON.");
//        } else {
//            this.state = ApplianceState.OFF;
//            System.out.println("The light is now OFF.");
//        }
    }

    public ApplianceState getState() {
        return this.state;
    }
}

class AirConditioner {
    private ApplianceState state;
    private String mode;

    public AirConditioner() {
        this.state = ApplianceState.OFF;
        this.mode = "off";  // Default mode is "off"
    }

    public void toggle() {
        if (this.state == ApplianceState.OFF) {
            this.state = ApplianceState.ON;
            this.mode = "cooling";  // When turning on, set mode to "cooling"
            System.out.println("The air conditioner is now ON in cooling mode.");
        } else {
            this.state = ApplianceState.OFF;
            this.mode = "off";  // When turning off, set mode to "off"
            System.out.println("The air conditioner is now OFF (thermostat set to 'off' mode).");
        }
    }

    public ApplianceState getState() {
        return this.state;
    }

    public String getMode() {
        return this.mode;
    }
}

class Fan {
    private int speed;

    public Fan() {
        this.speed = 0;
    }

    public void toggle() {
        if (this.speed == 0) {
            this.speed = 1;
            System.out.println("The fan is now at speed 1");
        } else if (this.speed == 1) {
            this.speed = 2;
            System.out.println("The fan is now at  speed 2");
        } else {
            this.speed = 0;
            System.out.println("The fan is now at speed 0");
        }
    }

    public int getSpeed() {
        return this.speed;
    }
}

public class Main {

    public static final String INVALID_CHOICE_MESSAGE = "Invalid choice. Please enter y, n, or q.";
    public static final String EXIT_MESSAGE = "Exiting the system. Goodbye!";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

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
                case "L":
                    handleToggleAppliance(sc, light, "Light", light.getState().toString());
                    break;
                case "F":
                    handleToggleAppliance(sc, fan, "Fan", String.valueOf(fan.getSpeed()));
                    break;
                case "A":
                    handleToggleAppliance(sc, ac, "Air Conditioner", ac.getState().toString());
                    break;
                default:
                    System.out.println("Invalid selection. Please enter L, F, or A.");
                    break;
            }

        }

//        sc.close();
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

