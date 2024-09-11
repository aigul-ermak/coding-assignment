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
            System.out.println("The light is now ON.");
        } else {
            this.state = ApplianceState.OFF;
            System.out.println("The light is now OFF.");
        }
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

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Light light = new Light();
        AirConditioner ac = new AirConditioner();

        final String INVALID_CHOICE_MESSAGE = "Invalid choice. Please enter y, n, or q.";
        final String EXIT_MESSAGE = "Exiting the system. Goodbye!";

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
                    while (true) {
                        System.out.println("You selected Light. The current state is: " + light.getState());
                        System.out.println("Would you like to toggle the light? (y for yes, n for no, q to quit)");
                        String toggleChoice = sc.nextLine().toLowerCase();
                        if (toggleChoice.equals("y")) {
                            light.toggle();
                        } else if (toggleChoice.equals("n")) {
                            break;
                        } else if (toggleChoice.equals("q")) {
                            System.out.println(EXIT_MESSAGE);
                            System.exit(0);
                        } else {
                            System.out.println(INVALID_CHOICE_MESSAGE);
                        }
                    }
                    break;
                case "F":
                    System.out.println("You selected Fan.");
                    break;
                case "A":
                    while (true) {
                        System.out.println("You selected Air Conditioner. The current state is: " + ac.getState());
                        System.out.println("Would you like to toggle the air conditioner? (y for yes, n for no, q to quit)");
                        String toggleChoice = sc.nextLine().toLowerCase();
                        if (toggleChoice.equals("y")) {
                            ac.toggle();
                        } else if (toggleChoice.equals("n")) {
                            break;  //
                        } else if (toggleChoice.equals("q")) {
                            System.out.println(EXIT_MESSAGE);
                            System.exit(0);
                        } else {
                            System.out.println(INVALID_CHOICE_MESSAGE);
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid selection. Please enter L, F, or A.");
                    break;
            }

        }

//        sc.close();
    }
}

