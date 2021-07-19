package AdvancedOOP.Animals;

public class Dog extends Animal{
    private final int MAXRUN=500;
    private final int MAXSWIM=10;
    private final String TYPE="Dog";
//    static final String type = "Dog";

    public Dog(String name) {
        super(name);
        this.maxRun=MAXRUN;
        this.maxSwim=MAXSWIM;
        type=TYPE;
    }


}
