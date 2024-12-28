import java.util.List;

public class InternalDispatcher {
     List<ElevatorController>  elevatorControllerList = ElevatorCreator.elevatorControllerList;

     public void submitInternalRequest(int floor, ElevatorCar elevatorCar) {
        for (ElevatorController controller : elevatorControllerList) {
            if (controller.elevatorCar == elevatorCar) {
                controller.submitInternalRequest(floor);
            }
        }
    }
    
}
