# Elevator System Simulation

This project simulates the functioning of an elevator system in a building, demonstrating the low-level design of elevators and their controllers. The simulation handles both internal and external requests for elevators, moving the elevators accordingly while displaying their states in real-time.

---

## Features

- **Building with Multiple Floors:**
  - Allows floors to make external requests for elevators (UP/DOWN buttons).
  
- **Elevator Cars:**
  - Each elevator can process internal requests to go to specific floors.
  - Displays the current floor and direction of movement.
  
- **Controllers:**
  - Each elevator has a controller to manage requests and move the elevator accordingly.
  - Uses priority queues to handle requests in an efficient manner.
  
- **Dispatcher System:**
  - Internal and external dispatchers route requests to the appropriate elevators.

---

## Design Components

### 1. Building
- Represents a building with multiple floors.
- Allows adding and removing floors.
- Provides methods for floors to make external requests.

### 2. Floors
- Each floor can request an elevator using UP or DOWN buttons.
- Requests are routed to the appropriate elevator controller via the external dispatcher.

### 3. Elevator Car
- Represents an individual elevator.
- Manages its own state (e.g., current floor, direction, door status).
- Moves between floors to process requests.

### 4. Controllers
- Each elevator has a controller to process internal and external requests.
- Handles requests using priority queues:
  - `upMinPQ` for UP requests.
  - `downMaxPQ` for DOWN requests.

### 5. Dispatchers
- **External Dispatcher:** Routes external floor requests to the nearest or most appropriate elevator.
- **Internal Dispatcher:** Routes requests made from inside the elevator.

---

## How to Run

1. **Setup:**
   - Ensure you have Java installed (version 17 or later).
   - Clone the repository or copy the source files to your project directory.

2. **Compile the Code:**
   ```bash
   javac Main.java
   ```

3. **Run the Simulation:**
   ```bash
   java Main
   ```

4. **Output:**
   - The simulation will log elevator movements and states in the console.

---

## Sample Output

```
Starting Elevator System Simulation...
Floor 1 pressing UP button...
Floor 2 pressing DOWN button...
Simulation running. Check logs for elevator movements.
Starting controller for Elevator 1
Starting controller for Elevator 2
Elevator 2 moving DOWN to floor 2
Elevator 1 moving UP to floor 1
Elevator 2 is IDLE.
Elevator 1 is IDLE.
Exiting controller for Elevator 2
Exiting controller for Elevator 1
```

---

## Known Issues
- The simulation ends when all requests are processed; it does not dynamically handle new requests during runtime.
- Logging is minimal and could be improved with a structured logging framework.

---

## Future Enhancements
- Add support for dynamically handling requests while the simulation is running.
- Implement a more sophisticated request allocation algorithm.
- Introduce real-time graphical visualization of the elevator system.
- Extend the simulation to include features like maintenance mode and emergency handling.

---

## License
This project is licensed under the MIT License. Feel free to use, modify, and distribute it as per the license terms.
