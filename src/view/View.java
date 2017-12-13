package view;

import logic.Logic;
import model.*;

/**
 * Class View demonstrates the work of the program
 */
public class View {

    public static void main(String[] args) {
        Logic logic = new Logic();
        logic.init();

        for(FFColumn col : logic.gasStation.listColumns){
            System.out.println("\nNew fuel column created. Information: " + col.toString());
        }

        logic.startColumnsThreads();
    }
}
