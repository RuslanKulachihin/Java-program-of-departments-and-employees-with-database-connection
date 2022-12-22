package service;
import organization.Departments;
import sourse.Repository;
import java.util.List;

public class DepartmentsService implements Service<Departments> {

    private final Repository<Departments> repository;

    public DepartmentsService(Repository<Departments> repository) {
        this.repository = repository;
    }

    @Override
    public Departments getById(int id) {
        return repository.find(id);
    }

    @Override
    public List<Departments> getAll() {
        return repository.list();
    }

    @Override
    public void save(Departments source) {
        repository.save(source);
    }
}
