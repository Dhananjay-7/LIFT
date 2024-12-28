import java.util.List;

public class Building {
    List<Floors> floors;

    public Building(List<Floors> floors) {
        this.floors = floors;
    }

    public void addFloor(Floors floor) {
        floors.add(floor);
    }

    public void removeFloor(Floors floor) {
        floors.remove(floor);
    }
    List<Floors> getAllFloors() {
        return floors;
    }
    
}
