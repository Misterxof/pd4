package model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class GasStation
 */
public class GasStation {

    private static Logger LOGGER = LogManager.getLogger(GasStation.class);

    private int number;
    private CarQueue carQueue;
    public ArrayList<FFColumn> listColumns;
    private Fuel fuel;
    private int carsCount;

    /**
     * Constructor for class GasStation
     * @param carsCount - count of cars
     * @param number - count of fuel columns
     * @param carQueue - cars queue
     */
    public GasStation(int carsCount, int number, CarQueue carQueue){
        this.carsCount = carsCount;
        this.number = number;
        this.carQueue = carQueue;
        listColumns = new ArrayList<>();
    }

    /**
     * The method create N(number) objects of type FFColumn
     */
    public void initialize(){

        for(int i = 0; i < number; i++){

            Random random = new Random();
            int x = random.nextInt(3);

            if(x == 1) fuel = fuel.SUPER;
            else if(x == 2) fuel = fuel.PREMIUM;
            else fuel = fuel.EXTRA;

            FFColumn column = new FFColumn(15, i, carQueue, fuel);
            listColumns.add(column);
        }

        LOGGER.debug("\nFuel columns created.");

        carQueue.addCountCars(carsCount);

        LOGGER.debug("The " + carsCount + " cars will be arrived");
    }

    /**
     * The method create and start threads for objects of FFColumn class
     */
    public void startWorkColumns(){
        for(FFColumn col : listColumns) {
            new Thread(col).start();
            LOGGER.debug("New thread started. Column number: " + col.number);
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
     * @param number - count of fuel columns
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
     * The method returns listColumns
     * @return listColumns
     */
    public ArrayList<FFColumn> getListColumns() {
        return listColumns;
    }

    /**
     * The method set listColumns
     * @param listColumns - list of columns
     */
    public void setListColumns(ArrayList<FFColumn> listColumns) {
        this.listColumns = listColumns;
    }
}
