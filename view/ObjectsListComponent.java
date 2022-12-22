package view;


import service.Service;

public class ObjectsListComponent<T> extends AbstractComponent<T> {

    public ObjectsListComponent(Service<T> service) {
        super(ComponentType.LIST, service);
    }

    @Override
    public void draw() {
        System.out.println("----- Objects List -----");
        service.getAll().forEach(System.out::println);
        System.out.println("------------------------");
    }
}
