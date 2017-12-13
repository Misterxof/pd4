package model;

/**
 * Class FFColumns
 */
public class FFColumn implements Runnable {

    public int number;
    private CarQueue carQueue;
    private Fuel fuel, fuel2;

    /**
     * Constructor for class FFColumns
     * @param number - number of the fuel column
     * @param carQueue - cars queue
     * @param fuel - type of fuel
     * @param fuel2 - type of fuel
     */
    public FFColumn(int number, CarQueue carQueue, Fuel fuel, Fuel fuel2) {
        this.number = number;
        this.carQueue = carQueue;
        this.fuel = fuel;
        this.fuel2 = fuel2;
    }

    /**
     * Overriding the method run()
     */
    @Override
    public void run() {
        while (true) {
            carQueue.takeCar(number, fuel, fuel2);
            try {
                if(Thread.interrupted()){
                    System.out.println("\nBREAK " + number +"");
                    break;
                }
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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
     * @param fuel2 - type of fuel
     */
    public void setFuel2(Fuel fuel2) {
        this.fuel = fuel;
    }

    /**
     * The method returns fuel
     * @return fuel
     */
    public Fuel getFuel2() {
        return fuel2;
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
        return "\nNumber: " + number +  " Fuel: " + fuel + ", " + fuel2;
    }
}