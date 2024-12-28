    public class ElevatorDisplay {
        int floor ;
        Directions direction;

        public void setDisplay(int floor, Directions direction){
            this.floor = floor;
            this.direction = direction;
        }
        public void display(){
            System.out.println("Elevator is at floor: " + floor + " and moving in direction: " + direction);
        }
    }
