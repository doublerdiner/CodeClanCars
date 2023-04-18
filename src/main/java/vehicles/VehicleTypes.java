package vehicles;

public enum VehicleTypes {
    PETROL("Petrol Car", false),
    DIESEL("Diesel Car", false),
    HYBRID("Hybrid Car", true),
    ELECTRIC("Electric Car", true);

    private final String formattedName;
    private final boolean hasBattery;
    VehicleTypes(String formattedName, boolean hasBattery) {
        this.formattedName = formattedName;
        this.hasBattery = hasBattery;
    }

    public String getFormattedName() {
        return formattedName;
    }

    public boolean getHasBattery() {
        return hasBattery;
    }
}
