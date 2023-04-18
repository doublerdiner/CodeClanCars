package vehicles.parts;

public class Engine {
    private String name;
    private int power;
    private int maxSpeed;
    public Engine(String name, int power, int maxSpeed){
        this.name = name;
        this.power = power;
        this.maxSpeed = maxSpeed;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
