package service;
import organization.Employee;
import sourse.Repository;

import java.util.List;

public class EmployeesService implements Service<Employee> {

    private final Repository<Employee> repository;

    public EmployeesService(Repository<Employee> repository) {
        this.repository = repository;
    }

    @Override
    public Employee getById(int id) {
        return repository.find(id);
    }

    @Override
    public List<Employee> getAll() {
        return repository.list();
    }

    @Override
    public void save(Employee source) {
        repository.save(source);
    }
}
