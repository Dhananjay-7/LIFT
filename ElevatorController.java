        import java.util.PriorityQueue;


        public class ElevatorController {
            PriorityQueue<Integer> upMinPQ;
            PriorityQueue<Integer> downMaxPQ;
            ElevatorCar elevatorCar;

            ElevatorController(ElevatorCar elevatorCar){

                this.elevatorCar = elevatorCar;
                upMinPQ = new PriorityQueue<>();
                downMaxPQ = new PriorityQueue<>((a,b) -> b-a);

            }

            public void submitExternalRequest(int floor, Directions direction){

                if(direction == Directions.DOWN) {
                    downMaxPQ.offer(floor);
                } else {
                    upMinPQ.offer(floor);
                }
            }

            public void submitInternalRequest(int floor){
                if (floor > elevatorCar.currentFloor) {
                    upMinPQ.offer(floor);
                } else {
                    downMaxPQ.offer(floor);
                }
            }

            public void controlElevator() {
                while (true) {
                    try {
                        // Process UP direction
                        if (elevatorCar.elevatorDirection == Directions.UP) {
                            while (!upMinPQ.isEmpty()) {
                                int nextFloor = upMinPQ.poll();
                                System.out.println("Elevator " + elevatorCar.id + " moving UP to floor " + nextFloor);
                                elevatorCar.moveElevator(Directions.UP, nextFloor);
                            }
                            elevatorCar.elevatorDirection = Directions.DOWN; // Switch direction
                        }
            
                        // Process DOWN direction
                        if (elevatorCar.elevatorDirection == Directions.DOWN) {
                            while (!downMaxPQ.isEmpty()) {
                                int nextFloor = downMaxPQ.poll();
                                System.out.println("Elevator " + elevatorCar.id + " moving DOWN to floor " + nextFloor);
                                elevatorCar.moveElevator(Directions.DOWN, nextFloor);
                            }
                            elevatorCar.elevatorDirection = Directions.UP; // Switch direction
                        }
            
                        // If both queues are empty and elevator is idle, break the loop
                        if (upMinPQ.isEmpty() && downMaxPQ.isEmpty()) {
                            System.out.println("Elevator " + elevatorCar.id + " is IDLE.");
                            elevatorCar.elevatorState = ElevatorState.IDLE;
            
                            // Add a short delay for simulation and to avoid high CPU usage
                            Thread.sleep(1000);
            
                            // Exit loop if no more requests to process
                            if (upMinPQ.isEmpty() && downMaxPQ.isEmpty()) {
                                break;
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            
                System.out.println("Exiting controller for Elevator " + elevatorCar.id);
            }
            
            }
        
        
                
