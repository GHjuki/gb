package AdvancedOOP.Animals;

import AdvancedOOP.Barrier;
import AdvancedOOP.Road;
import AdvancedOOP.Water;

import java.sql.SQLOutput;

public class Animal {

    //static final String type = "Animal";
    protected String name,type="Animal";
    protected int maxRun=0,maxSwim=0;

    public Animal(String name) {
        this.name=name;
    }

    public boolean run (int distance) {
//        System.out.printf("((%s %s %d))\n",type,name,distance);
        if (distance<=maxRun&&distance>0) System.out.printf("%s %s run for %d meters\n",type,name,distance);
        else {
            System.out.printf("%s %s can't run this distance\n",type,name);
            return false;
        }
        return true;
    }

    public boolean swim (int distance) {
//        System.out.printf("%s %s %d\n",type,name,distance);
        if (distance<=maxSwim&&distance>0) System.out.printf("%s %s swim for %d meters\n", type,name,distance);
        else {
            System.out.printf("%s %s can't swim this distance\n",type,name);
            return false;
        }
        return true;
    }

    public boolean action (Barrier barrier) {
        if (barrier instanceof Water) {
            return swim(barrier.getDistance());
        }
        if (barrier instanceof Road) {
            return run(barrier.getDistance());
        }
        return false;
    }

    public String getInfo() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }
}
