package AdvancedOOP;

public abstract class Barrier {
//    static final String type;
    private int distance;

    public Barrier(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
}
