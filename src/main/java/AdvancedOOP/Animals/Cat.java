package AdvancedOOP.Animals;

public class Cat extends Animal{
    private final int MAXRUN=200;
    private final int MAXSWIM=0;
    private final String TYPE="Cat";
//    static final String type = "Cat";

    public Cat(String name) {
        super(name);
        this.maxRun=MAXRUN;
        this.maxSwim=MAXSWIM;
        type=TYPE;
    }


}
