package FeedCats;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety=false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }
    public void eat(Plate p) {
        if (p.decreaseFood(this.appetite)) {
            this.satiety=true;
            System.out.println(this.name + " eat "+ this.appetite + " food");
        }
        else  {
            this.satiety=false;
            System.out.println(this.name + " can't eat");
        }
    }
    public void isSatient() {
        if(this.satiety) System.out.println(this.name + " cыт!");
        else System.out.println(this.name + " голоден");
    }
}
