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

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Light light = new Light();

        System.out.println("Hi! You are in the Smart Home Appliance Control System!");

        while (true) {
            System.out.println("What do you want to choose: Light, Fan, or Air Conditioner?");

            System.out.println("Enter L for Light, F for Fan, A for Air Conditioner, or Q to quit");

            String choice = sc.nextLine().toUpperCase();

            if (choice.equals("Q")) {
                System.out.println("Exiting the system. Bye!");
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
                            System.out.println("Exiting the system. Bye!");
                            System.exit(0);
                        } else {
                            System.out.println("Invalid choice. Please enter y, n, or q.");
                        }
                    }
                    break;
                case "F":
                    System.out.println("You selected Fan.");
                    break;
                case "A":
                    System.out.println("You selected Air Conditioner.");
                    break;
                default:
                    System.out.println("Invalid selection. Please enter L, F, or A.");
                    break;
            }

        }

//        sc.close();
    }
}

