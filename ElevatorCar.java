public class ElevatorCar {
    int id;
    ElevatorDisplay display;
    InternalButton internalButtons;
    ElevatorState elevatorState;
    int currentFloor;
    Directions elevatorDirection;
    ElevatorDoor elevatorDoor;

     public ElevatorCar(){
        display = new ElevatorDisplay();
        internalButtons = new InternalButton();
        elevatorState = ElevatorState.IDLE;
        currentFloor = 0;
        elevatorDirection = Directions.UP;
        elevatorDoor = new ElevatorDoor();

    }
    public void showDisplay() {
        display.display();
   }

   public void pressButton(){
         internalButtons.pressButton(currentFloor, this);
   }

   public void setDisplay() {
    this.display.setDisplay(currentFloor, elevatorDirection);
}

boolean moveElevator(Directions dir, int destinationFloor){
    int startFloor = currentFloor;
    if(dir == Directions.UP) {
        for(int i = startFloor; i<=destinationFloor; i++) {

            this.currentFloor = startFloor;
            setDisplay();
            showDisplay();
            if(i == destinationFloor) {
                return true;
            }
        }
    }

    if(dir == Directions.DOWN) {
        for(int i = startFloor; i>=destinationFloor; i--) {

            this.currentFloor = startFloor;
            setDisplay();
            showDisplay();
            if(i == destinationFloor) {
                return true;
            }
        }
    }
    return false;
}

}
