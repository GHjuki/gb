package lessons;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords() {
        System.out.println("_Orange\n_Banana\n_Apple");
    }

    public static void checkSumSign() {
        int a = -8,b = 7;
        if ((a+b) >= 0) System.out.println("Сумма положительная");
        else System.out.println("Сумма отрицательная");
    }

    public static void printColor() {
        int value=33;
        if (value < 0) System.out.println("Красный");
        else if ((value > 0) && (value < 100)) System.out.println("Желтый");
        else if (value > 100) System.out.println("Зеленый");
    }

    public static void compareNumbers() {
        int a = 3, b = 7;
        if (a >= b) System.out.println("a >= b");
        else System.out.println("a < b");
    }
}
