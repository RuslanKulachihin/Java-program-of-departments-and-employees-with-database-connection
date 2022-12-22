package organization;

public class Employee {
    private int id;
    private String fio;
    private int age;
    private Gender gender;

    private int id_depart;

    public Employee(int id, String fio, int age, Gender gender, int id_depart)
    {
        this.id = id;
        this.fio = fio;
        this.age = age;
        this.gender = gender;
        this.id_depart = id_depart;
    }

    public int getId() {
        return id;
    }
    public int getId_depart() {
        return id_depart;
    }

    public String getFio() {
        return fio;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }
    @Override
    public String toString()
    {
        return "Employees{" +
                "id=" + id +
                ", fio ='" + fio + '\'' +
                ", age=" + age+
                ", Gender ='" + gender.getText() + '\'' +
                ", id_depart=" + id_depart+
                '}';
    }
}
