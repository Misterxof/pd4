package model;

/**
 * Class FFColumns
 */
public class FFColumn implements Runnable {

    private int maxCountFuel;
    public int number;
    private CarQueue carQueue;
    private Fuel fuel;

    /**
     * Constructor for class FFColumns
     * @param maxCountFuel - max number of fuel
     * @param number - number of the fuel column
     * @param carQueue - cars queue
     * @param fuel - type of fuel
     */
    public FFColumn(int maxCountFuel, int number, CarQueue carQueue, Fuel fuel) {
        this.maxCountFuel = maxCountFuel;
        this.number = number;
        this.carQueue = carQueue;
        this.fuel = fuel;
    }

    /**
     * Overriding the method run()
     */
    @Override
    public void run() {
        while (maxCountFuel > 0) {
            carQueue.takeCar(number, fuel);
            maxCountFuel--;

            try {
                if(Thread.interrupted()){
                    break;
                }
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * The method returns maxCountFuel
     * @return maxCountFuel
     */
    public int getMaxCountFuel() {
        return maxCountFuel;
    }

    /**
     * The method set maxCountFuel
     * @param maxCountFuel - max number of fuel
     */
    public void setMaxCountFuel(int maxCountFuel) {
        this.maxCountFuel = maxCountFuel;
    }

    /**
     * The method returns number
     * @return number
     */
    public int getNumber() {
        return number;
    }

    /**
     * The method set number
     * @param number - number of the fuel column
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * The method returns carQueue
     * @return carQueue
     */
    public CarQueue getCarQueue() {
        return carQueue;
    }

    /**
     * The method set carQueue
     * @param carQueue - cars queue
     */
    public void setCarQueue(CarQueue carQueue) {
        this.carQueue = carQueue;
    }

    /**
     * The method returns fuel
     * @return fuel
     */
    public Fuel getFuel() {
        return fuel;
    }

    /**
     * The method set fuel
     * @param fuel - type of fuel
     */
    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    /**
     * Overriding the method toString()
     * @return string
     */
    @Override
    public String toString(){
        return "\nNumber: " + number + " Max fuel: " + maxCountFuel +  " Fuel: " + fuel + ".";
    }
}