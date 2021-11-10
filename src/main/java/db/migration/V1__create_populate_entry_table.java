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
                "INSERT INTO Entry (Id, Title, Body, Created_At, Updated_At) VALUES (1, 'let''s talk florets!', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse at ante non magna sodales mattis et sit amet arcu. Sed ac mollis elit, nec pellentesque ante. Nulla semper semper vehicula. Sed in eleifend velit. Aliquam viverra felis sit amet purus elementum, vel finibus risus pulvinar. Sed non ornare ex. Vivamus at arcu semper, fringilla nisi vitae, fermentum ligula. Cras et orci quis mi dapibus accumsan. Pellentesque maximus vel enim quis vehicula. Ut quis sem laoreet, sollicitudin nisi sit amet, lobortis mi.\n" +
                "\n" +
                "Morbi imperdiet sodales vestibulum. Nam pellentesque et tortor a fringilla. Donec porta euismod eros. In a odio non arcu volutpat mattis id eget eros. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Vivamus metus nisi, faucibus at placerat sed, vulputate ac sapien. Ut venenatis, ex in tincidunt tincidunt, urna turpis congue est, non sollicitudin elit ex quis metus.\n" +
                "\n', '" + now + "', '" + now + "'); " +
                "INSERT INTO Entry (Id, Title, Body, Created_At, Updated_At) VALUES (2, 'Omg! You can char-broil broccoli?! Yum!', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque risus nisi, congue ut lectus non, tempor dictum lectus. Pellentesque et libero auctor, egestas augue vel, elementum ante. Nullam non nibh justo. Vivamus et dolor eget diam iaculis luctus. Sed eget leo euismod, viverra mi non, maximus turpis. Praesent vestibulum consectetur ornare. Proin vel massa quis purus fermentum tempus. Fusce euismod dolor at porta consequat. Aliquam non suscipit enim. Donec porttitor nec risus eu imperdiet. Aliquam vulputate dapibus rhoncus. Vivamus a accumsan ante. Cras iaculis purus sed magna pulvinar convallis.\n" +
                "\n" +
                "Praesent sit amet massa ultricies, elementum metus sit amet, pharetra magna. In hac habitasse platea dictumst. Integer sit amet urna enim. Cras blandit pellentesque eros, vitae suscipit nisi lacinia vel. Praesent blandit rhoncus auctor. Cras maximus eros porta, tincidunt ex posuere, facilisis lacus. Phasellus vel pharetra lacus, vitae sollicitudin dolor. Proin nec dignissim lacus, sed vestibulum lacus', '" + now + "', '" + now + "'); " +
                "INSERT INTO Entry (Id, Title, Body, Created_At, Updated_At) VALUES (3, 'Cruciferous Crucible', 'The knight rideth through the entrance of the hall, driving straight to the high daïs, and greeted no man, but looked ever upwards; and the first words he spake were, \"Where is the ruler of this folk? I would gladly look upon that hero, and have speech with him.\" He cast his eyes on the knights, and mustered them up and down, striving ever to see who of them was of most renown.\n" +
                "\n" +
                "Then was there great gazing to behold that chief, for each man marvelled what it might mean that a knight and his steed should have even such a hue as the green grass; and that seemed even greener than green enamel on bright gold. All looked on him as he stood, and drew near unto him wondering greatly what he might be; for many marvels had they seen, but none such as this, and phantasm and faërie did the folk deem it. Therefore were the gallant knights slow to answer, and gazed astounded, and sat stone still in a deep silence through that goodly hall, as if a slumber were fallen upon them. I deem it was not all for doubt, but some for courtesy that they might give ear unto his errand.', '" + now + "', '" + now + "'); ";

        try (PreparedStatement statement =
                     context
                             .getConnection()
                             .prepareStatement(query)) {
            statement.execute();
        }
    }
}


