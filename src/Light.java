public class Light {
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
    }

    public void turnOffForUpdate() {
        this.state = ApplianceState.OFF;
        System.out.println("The light has been turned " + this.state + " for the system update.");
    }

    public ApplianceState getState() {
        return this.state;
    }

}
