import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        System.out.println("Starting Elevator System Simulation...");
        List<Floors> floorsList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            floorsList.add(new Floors(i));
        }
        Building building = new Building(floorsList);
        // Simulate requests
       
        Floors floor1 = floorsList.get(0);
        Floors floor2 = floorsList.get(1);


        System.out.println("Floor 1 pressing UP button...");
        floor1.pressButton(Directions.UP);
        System.out.println("Floor 2 pressing DOWN button...");
        floor2.pressButton(Directions.DOWN);

        // Start elevator controllers
        for (ElevatorController controller : ElevatorCreator.elevatorControllerList) {
            new Thread(() -> {
                System.out.println("Starting controller for Elevator " + controller.elevatorCar.id);
                controller.controlElevator();
            }).start();
        }
        System.out.println("Simulation running. Check logs for elevator movements.");

        }
    }
