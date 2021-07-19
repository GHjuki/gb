package OOP;

public class Worker {

    private String fio;
    private String position;
    private String email;
    private String phone;
    private int zp;
    private int age;

    public Worker(String fio, String position, String email, String phone, int zp, int age) {
        this.fio=fio;
        this.position=position;
        this.email=email;
        this.phone=phone;
        this.zp=zp;
        this.age=age;
    }

    protected int getAge() {
        return this.age;
    }

    protected void getInfo() {
        System.out.printf("ФИО: %s, должность: %s, email: %s, телефон: %s, оклад: %d, возраст: %d\n", this.fio, this.position, this.email, this.phone, this.zp, this.age);
    }
}
