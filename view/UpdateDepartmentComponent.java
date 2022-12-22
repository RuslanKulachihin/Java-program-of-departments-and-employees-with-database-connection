package view;


import organization.Departments;
import service.Service;

import java.util.Scanner;

public class UpdateDepartmentComponent extends AbstractComponent<Departments> {

    protected UpdateDepartmentComponent(Service<Departments> service) {
        super(ComponentType.UPDATE_BOX, service);
    }

    @Override
    public void draw() {
        Scanner keyboard = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Enter id of department you want to update: ");
        int id = keyboard.nextInt();
        System.out.print("Enter box name: ");
        String name = keyboard.next();
        service.save(new Departments(id, name,null));
        System.out.println("The department has been updated\n");
    }
}
