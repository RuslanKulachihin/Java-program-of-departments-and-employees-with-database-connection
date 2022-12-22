package organization;

import java.util.ArrayList;
import java.util.List;

public class Departments {
    private int id;
    private String title;
    private List<Employee> employeesList;

    public Departments(int id,String title,List<Employee> employeesList)
    {
        this.id = id;
        this.title =title;
        this.employeesList = employeesList;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public  List<Employee> getEmployeesList()
    {
        return employeesList;
    }
    @Override
    public String toString() {
        List<String> fio = new ArrayList<>();
        for(int i =0;i<employeesList.size();i++)
        {
            fio.add(employeesList.get(i).getFio());
        }

        return "Department{" +
                "id=" + id +
                ", title ='" + title + '\'' +
                ", employees=" + fio+
                '}';
    }
}
