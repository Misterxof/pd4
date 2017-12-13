package model;

import java.util.Random;

/**
 * Class Car
 */
public class Car {

    public Fuel fuel;
    private String name;
    private int x;
    Random random;

    /**
     * Constructor for class Car
     * @param name - name of the car
     */
    public Car(String name) {
        this.name = name;

        random = new Random();
        x = random.nextInt(3);

        if(x == 1) fuel = fuel.SUPER;
        else if(x == 2) fuel = fuel.PREMIUM;
        else fuel = fuel.EXTRA;
    }

    /**
     * The method returns name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * The method set name
     * @param name - name of the car
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Overriding the method toString()
     * @return string
     */
    @Override
    public String toString(){
        return "" + name + " Fuel: " + fuel;
    }
}
