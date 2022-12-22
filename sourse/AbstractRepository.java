package sourse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public abstract class AbstractRepository<T> implements Repository<T> {

    protected final Connection connection;

    public AbstractRepository(DBConnector connector) {
        connection = connector.getConnection();
    }

    protected List<T> executeSelect(String query, SQLStatementConsumer consumer, Mapper<T> mapper)
    {
        try (
                PreparedStatement statement = connection.prepareStatement(query);
        ) {
            if (consumer != null ) {
                consumer.accept(statement);
            }
            ResultSet resultSet = statement.executeQuery();
            List<T> depart = new ArrayList<>();
            while (resultSet.next()) {

                T box = mapper.map(resultSet);
                depart.add(box);
            }
            return depart;
        } catch (SQLException e) {
            throw new RuntimeException("Error while Repository::list method executing: " + e);
        }
    }
    protected int execute(String query, SQLStatementConsumer consumer) {
        try (
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            consumer.accept(statement);
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error while Repository::save method executing: " + e);
        }
    }
}
