package view;


import service.Service;

import java.util.Scanner;

public class SingleObjectComponent<T> extends AbstractComponent<T> {

    protected SingleObjectComponent(Service<T> service) {
        super(ComponentType.SINGLE, service);
    }

    @Override
    public void draw() {
        System.out.println("----- One Object -----");
        System.out.print("Enter object id: ");
        Scanner scanner = new Scanner(System.in);
        long given = scanner.nextLong();
        T object = service.getById((int) given);
        System.out.println(object);
        System.out.println("----------------------");
    }
}

