package AdvancedOOP;

import AdvancedOOP.Animals.*;

public class MainAnimalTest {
    public static void main(String[] args) {
        Animal[] animal = {
                new Dog("Sharick"),
                new Cat("Barsick"),
                new Cat("Muska"),
                new Cat("Murzyck"),
                new Dog("Bobick")
        };


        Barrier[] barrier = {
                new Road(50),
                new Water(10),
                new Water(5),
                new Road(100),
                new Road(500),
                new Road(10),
                new Road(1000)
        };

        int sumCat=0,sumDog=0;
        for (int i = 0; i < animal.length; i++) {
            if (animal[i].getType()=="Dog") sumDog++;
            if (animal[i].getType()=="Cat") sumCat++;
        }
        System.out.printf("Cats:%d     Dog:%d\n",sumCat,sumDog);

        for (int i = 0; i < animal.length; i++) {
            System.out.printf("%s on start! \n",animal[i].getInfo());
            for (int j = 0; j < barrier.length; j++) {
                if (!animal[i].action(barrier[j]))
                    break;
            }
            System.out.println("-----------");
        }

    }
}
