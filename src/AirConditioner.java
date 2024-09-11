public class AirConditioner {
    private ApplianceState state;
    private String mode;

    public AirConditioner() {
        this.state = ApplianceState.OFF;
        this.mode = "off";
    }

    public void toggle() {
        if (this.state == ApplianceState.OFF) {
            this.state = ApplianceState.ON;
            this.mode = "cooling";
            System.out.println("The air conditioner is now ON in cooling mode.");
        } else {
            this.state = ApplianceState.OFF;
            this.mode = "off";
            System.out.println("The air conditioner is now OFF (thermostat set to 'off' mode).");
        }
    }

    public void turnOffForUpdate() {
        this.state = ApplianceState.OFF;
        this.mode = "off";
        System.out.println("The air conditioner has been turned " + this.state + " for the system update.");
    }

    public ApplianceState getState() {
        return this.state;
    }

    public String getMode() {
        return this.mode;
    }
}
