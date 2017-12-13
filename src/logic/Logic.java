package logic;

import model.AddCarThread;
import model.CarQueue;
import model.GasStation;

/**
 * Class Logic
 */
public class Logic {

    public Thread addCars;
    public CarQueue carQueue;
    public GasStation gasStation;
    public AddCarThread cars;

    public Logic(){}

    /**
     * The method initialize the program
     */
    public void init(){

        carQueue = new CarQueue();
        gasStation = new GasStation(30,8, carQueue);

        gasStation.initialize();

        cars = new AddCarThread(carQueue);
        addCars = new Thread(cars);
    }

    /**
     * The method start threads
     */
    public void startColumnsThreads(){
        addCars.start();
        gasStation.startWorkColumns();
    }

}
