

import organization.Departments;
import organization.Employee;
import sourse.*;
import service.DepartmentsService;
import service.Service;
import view.Component;
import view.ComponentFabric;
import service.EmployeesService;

import java.util.Scanner;
public class Main {


    public static void main(String[] args)  {

        DBConnector connector = new DBConnector();
        AbstractRepository<Departments> repository = new DepartmentRepository(connector);
        AbstractRepository<Employee> repository1 = new EmployeeRepository(connector);
        Service<Departments> service = new DepartmentsService(repository);
        Service<Employee> service1 = new EmployeesService(repository1);
        ComponentFabric fabric = new ComponentFabric();
        System.out.println("----- Enter 0 to see menu ----\n");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int command = scanner.nextInt();
            Component component = fabric.build(command, service,service1);
            if (component == null) {
                return;
            }
            component.draw();
        }
    }

}
