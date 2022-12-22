package view;

import organization.Departments;
import service.Service;

import java.util.Scanner;

public class CreateDepartmentComponent extends AbstractComponent<Departments> {

    protected CreateDepartmentComponent(Service<Departments> service) {
        super(ComponentType.CREATE_BOX, service);
    }

    @Override
    public void draw() {
        Scanner keyboard = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Enter box name: ");
        String name = keyboard.next();
        service.save(new Departments(0, name,null));
        System.out.println("New box has been created\n");
    }
}
