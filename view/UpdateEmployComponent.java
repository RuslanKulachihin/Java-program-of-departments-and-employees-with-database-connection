package view;


import organization.Employee;
import organization.Gender;
import service.Service;

import java.util.Scanner;

public class UpdateEmployComponent extends AbstractComponent<Employee>{

    protected  UpdateEmployComponent(Service<Employee> service) {
        super(ComponentType.UPDATE_EMPLOY, service);
    }
    @Override
    public void draw() {
        Scanner keyboard = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Enter id of employ you want to update: ");
        int id = keyboard.nextInt();

        System.out.print("Enter fio : ");
        String fio = keyboard.next();

        System.out.print("Enter age: ");
        int age;
        while (true){
            age = Integer.parseInt(keyboard.next());
            if (age<18)
                    System.out.print("Wrong age");

                else
                    break;


        }
        System.out.print("Enter gender MEN/FEMALE: ");
        String gender;

        while (true) {
            gender = keyboard.next();
            if (gender!="MEN"||gender!="FEMALE")
                System.out.print("Wrong gender");
            else
                break;
        }

        System.out.print("Enter id_depart: ");
        int id_depart = Integer.parseInt(keyboard.next());
        service.save(new Employee(id, fio,age, Gender.valueOf(gender),id_depart));
        System.out.println("The employ has been updated\n");
    }
}