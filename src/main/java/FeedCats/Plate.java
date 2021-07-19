package FeedCats;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }
    public boolean decreaseFood(int d) {
        if(d>this.food) return false;
        this.food-=d;
        return true;
    }
    public void addFood(int f) {
        this.food+=f;
    }
    public void info() {
        System.out.println("plate: "+ this.food);
    }
}
