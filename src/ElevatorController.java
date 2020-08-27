public class ElevatorController {

    Elevator[] elevators;

    public ElevatorController(Elevator[] elevators) {
        this.elevators = elevators;
        for (int i = 0; i < elevators.length; i++) {
            elevators[i].setId(i);
        }
    }

    private Elevator getNearestElevator(Elevator [] elevators, Request request) {
        int distance = 1000;
        int id = -1;
        for (Elevator elevator : elevators) {
            if (elevator.getDistance(request) < distance) {
                distance = elevator.getDistance(request);
                id = elevator.getId();
            }
        }
        return elevators[id];
    }

    public void addRequest(Request request) {
        Elevator e = getNearestElevator(elevators, request);
        e.addToRequests(request);
    }

    public Elevator[] getElevators() {
        return elevators;
    }
}