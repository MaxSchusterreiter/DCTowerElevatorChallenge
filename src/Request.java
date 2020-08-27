public class Request {

    private int curfloor;
    private int desfloor;
    private Direction direction;
    public int distance;

    public Request(int curfloor, int desfloor, Direction direction) {
        this.curfloor = curfloor;
        this.desfloor = desfloor;
        this.direction = direction;
        setDistance(curfloor, desfloor);
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

    public Direction getDirection() {
        return direction;
    }

    private void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int curfloor, int desfloor) {
        distance = Math.abs(desfloor - curfloor);
    }
}
