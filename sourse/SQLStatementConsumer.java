package sourse;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface SQLStatementConsumer {
    void accept(PreparedStatement statement) throws SQLException;
}
