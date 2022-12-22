package sourse;

import organization.Employee;
import organization.Gender;

import java.sql.Connection;
import java.util.List;

public class EmployeeRepository extends AbstractRepository<Employee> {
    private final Mapper<Employee> mapper = resultSet -> {

        int idn = resultSet.getInt("id_employees");
        String fio = resultSet.getString("fio");
        int age = resultSet.getInt("age");
        Gender gender = Gender.valueOf(resultSet.getString("gender"));
        int departmentId = resultSet.getInt("id_department");
        return new Employee(idn, fio, age, gender, departmentId);
    };

    public EmployeeRepository(DBConnector connector) {
        super(connector);
    }



    @Override
    public Employee find(int id) {
        String query = "select * from employees where id_employees = ?";
        List<Employee> employees = executeSelect(query, statement -> statement.setInt(1, id), mapper);
        if (employees.isEmpty()) {
            throw new RuntimeException("No elements found by given id");
        }
        return employees.get(0);
    }

    @Override
    public void save(Employee source) {
        String insertQuery = "insert into employees (fio,age,gender,id_department) values (?,?,?,?)";
        String updateQuery = "update employees set fio = ? , age = ? , gender = ?   where id_employees = ?";
        int rows;
        if (source.getId() == 0) {
            rows = execute(insertQuery, statement -> {
                statement.setString(1, source.getFio());
                statement.setInt(2, source.getAge());
                statement.setString(3, source.getGender().toString());
                statement.setInt(4, source.getId_depart());
            });
        } else {
            rows = execute(updateQuery, statement -> {
                statement.setString(1, source.getFio());
                statement.setInt(2, source.getAge());
                statement.setString(3, source.getGender().getText());
                statement.setInt(4, source.getId_depart());
            });
        }
        System.out.println("Rows affected: " + rows);
    }

    @Override
    public void remove(Employee target) {
        String query = "delete from employees where id_employees = ?";
        int rows = execute(query, statement -> statement.setLong(1, target.getId()));
        System.out.println("Rows affected: " + rows);
    }

    @Override
    public List<Employee> list() {
        String query = "select * from employees";
        return executeSelect(query, null, mapper);
    }
}
