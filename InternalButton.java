public class InternalButton {
    InternalDispatcher dispatcher = new InternalDispatcher();
    int [] availableFloors= {1,2,3,4,5,6,7,8,9,10};

    void pressButton(int destination, ElevatorCar elevatorCar) {
        dispatcher.submitInternalRequest(destination, elevatorCar);
    }


}
