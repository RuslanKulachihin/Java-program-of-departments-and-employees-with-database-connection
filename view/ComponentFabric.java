package view;


import organization.Departments;
import organization.Employee;
import service.Service;

import java.util.HashMap;
import java.util.Map;

public class ComponentFabric {

    private final Map<ComponentType, Component> components;

    public ComponentFabric() {
        this.components = new HashMap<>();
    }

    public <T> Component build(int type, Service<Departments> service , Service<Employee> service1) {
        try {
            ComponentType componentType = ComponentType.fromType(type);

            return components.computeIfAbsent(componentType, (ct) -> {
                Component component;
                switch (ct) {
                    case MENU:
                        component = new MenuComponent();
                        break;
                    case SINGLE:
                        component = new SingleObjectComponent<Departments>(service);
                        break;
                    case LIST:
                        component = new ObjectsListComponent<Departments>(service);
                        break;
                    case CREATE_BOX:
                        component = new CreateDepartmentComponent(service);
                        break;
                    case UPDATE_BOX:
                        component = new UpdateDepartmentComponent(service);
                        break;
                    case LIST_EMPLOY:
                         component = new ObjectsListComponent<Employee>(service1);
                        break;
                    case SINGLE_EMPLOY:
                        component = new SingleObjectComponent<Employee>(service1);
                        break;
                    case CREATE_EMPLOY:
                        component = new CreateEmployComponent(service1);
                        break;
                    case UPDATE_EMPLOY:
                        component = new UpdateEmployComponent(service1);
                        break;
                    default:
                        component = null;
                }
                return component;
            });
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}

