

public class Floors {
    int floorNumber;
    ExternalDispatcher externalDispatcher;

    public Floors(int floorNumber){
        this.floorNumber = floorNumber;
        externalDispatcher = new ExternalDispatcher();
    }

    public void pressButton(Directions direction) {

        externalDispatcher.submitExternalRequest(floorNumber, direction);
    }

}
