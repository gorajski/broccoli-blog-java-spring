package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.PreparedStatement;
import java.time.LocalDateTime;

//Courtesy of Florian E. at https://stackoverflow.com/questions/32012241/flyway-migrations-not-persistent-in-h2-embedded-database
//Hint: See migration file must be part of directory /db/migration
//Hint: use a pattern like V1.0.1__name.sql 2 under scores
//Hint: depending on Flyway version you should start with a sql file version greater than 1.0 example 1.0.1.
//Hint: per default spring boot jpa drops your database content if using an in-memory database. See http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-sql.html section 28.3.3.

public class V1__create_populate_entry_table extends BaseJavaMigration {
    public void migrate(Context context) throws Exception {
        LocalDateTime now = LocalDateTime.now();

        String query = "CREATE TABLE Entry (Id INT auto_increment, Title VARCHAR, Body VARCHAR, Created_At TIMESTAMP, Updated_At TIMESTAMP); " +
                "INSERT INTO Entry (Id, Title, Body, Created_At, Updated_At) VALUES (1, 'omg', 'it worked!', '" + now + "', '" + now + "'); " +
                "INSERT INTO Entry (Id, Title, Body, Created_At, Updated_At) VALUES (2, 'omg', 'it worked again!', '" + now + "', '" + now + "'); " +
                "INSERT INTO Entry (Id, Title, Body, Created_At, Updated_At) VALUES (3, 'Healthy Broccolio', 'Eetza a-healtee broccolio!', '" + now + "', '" + now + "'); ";

        try (PreparedStatement statement =
                     context
                             .getConnection()
                             .prepareStatement(query)) {
            statement.execute();
        }
    }
}


