package lessons;

public class Lesson3 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        printArray(task5(3,2));
        task6();
        System.out.println(task7(new int[] {2,2,2,1,2,2,10,1}));
        task8(-2,new int[] {3,5,6,1});

    }

    private static void task8(int n, int... a)  {
        int tmp;
        if (n>=0) {
            for (int i = 0; i < n; i++) {
                tmp=a[a.length - 1];
                for (int j = a.length -1; j>0; j--) {
                    a[j]=a[j-1];
                }
                a[0]=tmp;
            }
        }
        else {
            for (int i = 0; i >n ; i--) {
                tmp=a[0];
                for (int j = 0; j < a.length-1; j++) {
                    a[j]=a[j+1];
                }
                a[a.length-1]=tmp;
            }
        }
        printArray(a);
    }

    private static boolean task7(int... a) {
        int left,right;
        for (int i = 1; i < a.length; i++) {
            left=right=0;
            for (int j = 0; j < a.length; j++) {
                if (j<i) left+=a[j];
                else right+=a[j];
            }
//            System.out.println(left + " " + right);
            if (left==right) return true;
        }
        return false;
    }

    private static void task6() {
        int a[] = {2,6,3,5,8,9,7,66,4,33,4,5,9,7,4,2,1};
        int min,max;
        min=max=a[1];
        for (int i = 0; i < a.length; i++) {
            if (a[i]<min) min=a[i];
            if (a[i]>max) max=a[i];
        }
        System.out.println("minimum is - " + min);
        System.out.println("maximum is - " + max);
    }

    private static int[] task5(int len, int initialValue) {
        int a[] = new int[len];
        for (int i = 0; i < len; i++) {
            a[i]=initialValue;
        }
        return a;
    }

    private static void task4() {
        int a[][] = new int [10][10];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if ((i == j) || (j == a[i].length - i - 1)) a[i][j] = 1;
                else a[i][j]=0;
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void task3() {
        int a[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 6) a[i]*=2;
        }
        printArray(a);
    }

    private static void task2() {
        int a[] = new int [100];
        for (int i = 0; i < 100; i++) {
            a[i]=i+1;
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    private static void task1() {
        int a[] = {0,0,0,1,0,0,1,1,0,1,0};
        // выводим первонаячальный массив на экран
        printArray(a);
        // меняем и выводим новый массив на экран
        for (int i = 0; i < a.length; i++) a[i]=1-a[i];
        printArray(a);
    }

    private static void printArray(int[] a) {     //часто печатаем массивы, сделаем отдельный метод
        for (int i = 0; i < a.length; i++) System.out.print(a[i] + " ");
        System.out.println();
    }
}
