package view;

import organization.Employee;
import organization.Gender;
import service.Service;

import java.util.Scanner;

public class CreateEmployComponent extends AbstractComponent<Employee> {

    protected CreateEmployComponent(Service<Employee> service) {
        super(ComponentType.CREATE_EMPLOY, service);
    }
    @Override
    public void draw() {
        Scanner keyboard = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Enter fio: ");
        String fio = keyboard.next();
        System.out.print("Enter age: ");
        int age = Integer.parseInt(keyboard.next());
        System.out.print("Enter gender MEN/FEMALE: ");
        String gender = keyboard.next();
        System.out.print("Enter id_depart: ");
        int id_depart = Integer.parseInt(keyboard.next());
        service.save(new Employee(0, fio,age, Gender.valueOf(gender),id_depart));
        System.out.println("New Employees has been created\n");

    }
}
