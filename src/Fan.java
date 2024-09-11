public class Fan {
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

    public void turnOffForUpdate() {
        this.speed = 0;
        System.out.println("The fan has been turned OFF for the system update.");
    }

    public int getSpeed() {
        return this.speed;
    }
}
