public class Main {

    public static void main(String[] args) {
        Elevator elevator1 = new Elevator();
        Elevator elevator2 = new Elevator();
        Elevator elevator3 = new Elevator();
        Elevator elevator4 = new Elevator();
        Elevator elevator5 = new Elevator();
        Elevator elevator6 = new Elevator();
        Elevator elevator7 = new Elevator();

        Thread elevatorThread1 = new Thread(elevator1);
        Thread elevatorThread2 = new Thread(elevator2);
        Thread elevatorThread3 = new Thread(elevator3);
        Thread elevatorThread4 = new Thread(elevator4);
        Thread elevatorThread5 = new Thread(elevator5);
        Thread elevatorThread6 = new Thread(elevator6);
        Thread elevatorThread7 = new Thread(elevator7);

        elevatorThread1.start();
        elevatorThread2.start();
        elevatorThread3.start();
        elevatorThread4.start();
        elevatorThread5.start();
        elevatorThread6.start();
        elevatorThread7.start();

        Elevator[] elevators = new Elevator[] {elevator1, elevator2, elevator3, elevator4, elevator5, elevator6, elevator7};
        ElevatorController elevatorController = new ElevatorController(elevators);

        Request request1 = new Request(0, 10, Direction.UP);
        Request request2 = new Request(4, 2, Direction.DOWN);
        Request request3 = new Request(11, 15, Direction.UP);
        Request request4 = new Request(0, 55, Direction.UP);
        Request request5 = new Request(0, 24, Direction.UP);
        Request request6 = new Request(0, 38, Direction.UP);
        Request request7 = new Request(0, 35, Direction.UP);
        Request request8 = new Request(7, 11, Direction.UP);
        Request request9 = new Request(4, 30, Direction.UP);
        Request request10 = new Request(45, 28, Direction.DOWN);
        Request request11 = new Request(45, 10, Direction.DOWN);
        Request request12 = new Request(6, 20, Direction.UP);
        Request request13 = new Request(29, 2, Direction.DOWN);
        Request request14 = new Request(35, 25, Direction.DOWN);

        elevatorController.addRequest(request1);
        elevatorController.addRequest(request2);
        elevatorController.addRequest(request3);
        elevatorController.addRequest(request4);
        elevatorController.addRequest(request5);
        elevatorController.addRequest(request6);
        elevatorController.addRequest(request7);
        elevatorController.addRequest(request8);
        elevatorController.addRequest(request9);
        elevatorController.addRequest(request10);
        elevatorController.addRequest(request11);
        elevatorController.addRequest(request12);
        elevatorController.addRequest(request13);
        elevatorController.addRequest(request14);
    }
}
