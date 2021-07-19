package lessons;

public class Lesson2 {
    public static void main(String[] args) {
        System.out.println(check2sum(5,15));
        isPositiv(-2);
        System.out.println(isNegativ(-2));
        stringNum("STRING",2);
        System.out.println(isVisokosny(2021));
    }

    private static boolean check2sum(int a, int b) {
        return ((a+b)<=20 && (a+b)>=10);
    }

    private static void isPositiv (int a) {
        System.out.println(a>=0?"Положительное":"Отрицательное");
    }

    private static boolean isNegativ(int a) {
        return a<0;
    }

    private static void stringNum(String s,int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(s);
        }
    }

    private static boolean isVisokosny(int a) {
        boolean b;
        if (a % 4 != 0) return false;
        else if (a % 100 != 0) return true;
        else if (a % 400 == 0) return true;
        else return false;
    }

}
