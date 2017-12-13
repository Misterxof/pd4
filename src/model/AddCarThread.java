package model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class AddCarThread
 */
public class AddCarThread implements Runnable{

    private static Logger LOGGER = LogManager.getLogger(CarQueue.class);

    private CarQueue carQueue;
    private static int idCar;

    /**
     * Constructor for class AddCarThread
     * @param carQueue - cars queue
     */
    public AddCarThread(CarQueue carQueue) {
        this.carQueue = carQueue;
    }

    /**
     * Overriding the method run()
     */
    @Override
    public void run() {
        while (carQueue.addCars( "car: " + idCar++)) {
        }
        LOGGER.debug("All cars arrived.");
    }
}
