package FeedCats;

public class Mainclass {
    public static void main(String[] args) {
        Cat[] cat = new Cat[7];
        cat[0] = new Cat("Barsick", 12);
        cat[1] = new Cat("Murzick", 15);
        cat[2] = new Cat("Muska", 20);
        cat[3] = new Cat("Filka", 25);
        cat[4] = new Cat("Mashka", 33);
        cat[5] = new Cat("Stasick", 24);
        cat[6] = new Cat("Quzya", 27);
        Plate plate = new Plate(100);
        for (Cat c: cat
             ) {
            c.eat(plate);
            plate.info();
        }
        for (Cat c: cat
        ) {
            c.isSatient();
        }

    }
}
