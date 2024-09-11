import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Hi! You are in the Smart Home Appliance Control System!");
        System.out.println("What do you want to choose: Light, Fan, or Air Conditioner?");

        System.out.println("Enter L for Light, F for Fan, or A for Air Conditioner:");

        String choice = sc.nextLine().toUpperCase();

        switch (choice) {
            case "L":
                System.out.println("You selected Light.");
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

        sc.close();
    }
}