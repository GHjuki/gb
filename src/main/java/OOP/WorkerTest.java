package OOP;

public class WorkerTest {
    public static void main(String[] args) {
        Worker[] worker = new Worker[5];
        worker[0] = new Worker("Ivanpv II", "Director", "iii@mail.ml", "56-46-34",50000, 89);
        worker[1] = new Worker("Petrov AT", "buhgalter", "buh@mail.ml", "880023489023", 40000, 70);
        worker[2] = new Worker("Sidorov KZ", "student", "stud@mail.ml", "604321 доб 5", 10000, 18);
        worker[3] = new Worker("Pelemen RT", "duty manager", "duty@mail.ml", "nope", 12000,39);
        worker[4] = new Worker("Kazlow EW", "tester", "test@mail.ml", "89121233445", 20000,23);


        for (int i = 0; i < 5; i++) {
            if(worker[i].getAge() > 40) worker[i].getInfo();

        }
    }
}
