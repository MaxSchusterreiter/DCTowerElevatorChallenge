import java.util.ArrayList;

public class Elevator implements Runnable {

    int id;
    private int curfloor;
    private int desfloor;
    final int maxfloor = 55;
    final int minfloor = 0;
    int distance;
    private boolean onRequest;
    private Direction direction;
    private final ArrayList<Request> requests;

    public Elevator() {
        curfloor = 0;
        onRequest = false;
        requests = new ArrayList<>();
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            if (!requests.isEmpty()) {
                try {
                    driving();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void driving() throws InterruptedException {
        Request r = requests.get(0);
        if (getCurfloor() > r.getCurfloor()) {
            onRequest = false;
            goingDown(getCurfloor(), r.getCurfloor());
        } else if (getCurfloor() < r.getCurfloor()) {
            onRequest = false;
            goingUp(getCurfloor(), r.getCurfloor());
        }
        if (getCurfloor() == r.getCurfloor()) {
            if (r.getDirection() == Direction.UP) {
                onRequest = true;
                goingUp(r.getCurfloor(), r.getDesfloor());
                requests.remove(r);
            } else if (r.getDirection() == Direction.DOWN) {
                onRequest = true;
                goingDown(r.getCurfloor(), r.getDesfloor());
                requests.remove(r);
            }
        }
    }

    private void goingUp(int curfloor, int desfloor) throws InterruptedException {
        setDesfloor(desfloor);
        for (int i = curfloor; i <= desfloor; i++) {
            Thread.sleep(1000);
            setCurfloor(i);
            printElevator();
        }
    }

    private void goingDown(int curfloor, int desfloor) throws InterruptedException {
        setDesfloor(desfloor);
        for (int i = curfloor; i >= desfloor; i--) {
            Thread.sleep(1000);
            setCurfloor(i);
            printElevator();
        }
    }

    private void printElevator() {
        if (curfloor != desfloor) {
            System.out.println("Elevator ID = " + getId() + " | Current Floor = " + getCurfloor() + " | Destination Floor = " + getDesfloor());
        } else {
            setDesfloor(getCurfloor());
            System.out.println("Elevator ID = " + getId() + " arrived at Destination Floor " + getDesfloor() + "!");
        }
    }

    public void addToRequests(Request r) {
        requests.add(r);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurfloor() {
        return curfloor;
    }

    private void setCurfloor(int curfloor) {
        this.curfloor = curfloor;
    }

    public int getDesfloor() {
        return desfloor;
    }

    private void setDesfloor(int desfloor) {
        this.desfloor = desfloor;
    }

    public int getMaxfloor() {
        return maxfloor;
    }

    public int getMinfloor() {
        return minfloor;
    }

    public Direction getDirection() {
        return direction;
    }

    private void setDirection(Direction direction) {
        this.direction = direction;
    }

    private void setDistance(int distance) {
        this.distance = distance;
    }

    private boolean isOnRequest() {
        return onRequest;
    }

    private void setOnRequest(boolean onRequest) {
        this.onRequest = onRequest;
    }

    public int getDistance(Request request) {
        int distance = 0;
        if (requests.isEmpty())
            return Math.abs(request.getCurfloor() - curfloor) + request.getDistance();
        for (int i = 0; i < requests.size(); i++) {
            if (i == 0) {
                if (isOnRequest()) {
                    distance += Math.abs(requests.get(i).getDesfloor() - curfloor);
                } else {
                    distance += Math.abs(requests.get(i).getCurfloor() - curfloor) + requests.get(i).getDistance();
                }
            }
            if (i > 0) {
                distance += Math.abs(requests.get(i-1).getDesfloor() - requests.get(i).getCurfloor()) + requests.get(i).getDistance();
            }
        }
        return distance + Math.abs(requests.get(requests.size()-1).getDesfloor() - request.getCurfloor()) + request.getDistance();
    }
}