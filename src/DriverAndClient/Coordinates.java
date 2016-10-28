package DriverAndClient;

public class Coordinates {

    private long valueX;
    private long valueY;

    public Coordinates(long ValueX, long ValueY){
        this.valueX = ValueX;
        this.valueY = ValueY;
    }

    public void setCoordinates(long newValueX, long newValueY){
        valueX=newValueX;
        valueY=newValueY;
    }

    public long getValueX() {
        return valueX;
    }

    public long getValueY() {
        return valueY;
    }
}
