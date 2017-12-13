package model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

/**
 * Class CarQueue
 */
public class CarQueue {

    private static Logger LOGGER = LogManager.getLogger(CarQueue.class);

    private ArrayList<Car> queueCars;
    private Integer countCars;
    private boolean hasCars;

    /**
     * Constructor for class CarQueue
     */
    public CarQueue(){
        queueCars = new ArrayList<>();
        countCars = 0;
    }

    /**
     * The method create and add objects of type Car into ArrayList queueCars.
     * Returns boolean hasCars: true - we have cars; false - no cars left
     * @param name - car name
     * @return hasCars
     */
    public boolean addCars(String name) {

        synchronized (countCars) {

            if (countCars > 0) {
                synchronized (queueCars) {

                        queueCars.add(0, new Car(name));

                    if(queueCars.size() >= 1) {
                        queueCars.notify();
                        LOGGER.debug("Cars arrived.");
                    }

                    System.out.println("\nAdd " + queueCars.get(0).toString() + ";");
                    countCars--;
                }
            }
            hasCars = (countCars != 0);
        }

        return hasCars;
    }

    /**
     * The method take car from ArrayList queueCars if fuel of car and fuel column are equals.
     * @param number - number of the fuel column
     * @param fuel - type of fuel
     */
    public void takeCar(int number, Fuel fuel) {

        synchronized (queueCars){
            int j = 0;

            if(queueCars.size() == 0 && hasCars) {
                try {
                    queueCars.wait();
                    LOGGER.debug("No cars left.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else if(queueCars.size() == 0 && !hasCars){
                Thread currentThread = Thread.currentThread();
                currentThread.interrupt();
            }
            else {
                for (int i = 0; i < queueCars.size(); i++) {
                    Car car = queueCars.get(i);
                    j++;
                    if (car.fuel.equals(fuel)) {
                        queueCars.remove(i);
                        j = 0;
                        System.out.println("\nColumn " + number + " fuel " + fuel + " fueled " + car.toString() + ";");
                        break;
                    }
                    else if (j == queueCars.size() && !hasCars) {
                            Thread currentThread = Thread.currentThread();
                            currentThread.interrupt();
                            j = 0;
                    }
                }
            }
        }
    }

    /**
     * The method add i cars
     * @param i - number of cars
     */
    public void addCountCars(int i) {
        countCars += i;
    }

}
