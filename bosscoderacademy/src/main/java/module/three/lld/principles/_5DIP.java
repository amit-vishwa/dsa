package module.three.lld.principles;

/**
 * Dependency Inversion Principle (DIP):
 * <p>
 * The Dependency Inversion Principle (DIP) is one of the five principles of the SOLID design principles in object-oriented programming.
 * DIP focuses on reducing dependencies between high-level and low-level modules in a software system.
 * <p>
 * The core tenet of DIP states:
 * - High-level modules should not depend on low-level modules; both should depend on abstractions.
 * - Abstractions should not depend on details; details should depend on abstractions.
 * - This principle promotes the use of interfaces or abstract classes to decouple the components of a system, enhancing maintainability,
 * scalability, and testability.
 * <p>
 * Explanation of DIP:
 * i.Understanding Dependencies:
 * - High-Level Module: This refers to a module that contains complex logic or processes, usually orchestrating the flow of the
 * application.
 * - Low-Level Module: This refers to a module that implements the details, such as specific functionality like database access, file
 * handling, etc.
 * In traditional designs, high-level modules directly depend on low-level modules, leading to tight coupling.
 * When changes are required in low-level modules (like switching from one database system to another), it necessitates changes in the
 * high-level modules, violating the Open/Closed Principle (OCP) as well.
 * <p>
 * Decoupling Through Abstraction:
 * - DIP suggests that both high-level and low-level modules should rely on abstractions rather than concrete implementations.
 * - This means defining interfaces that represent the desired behavior, which allows the low-level modules to be interchangeable
 * without affecting high-level modules.
 */
public class _5DIP {

    public static void main(String[] args) {
        badExample();
        goodExample();
    }

    /**
     * This is a bad example, because high level modules are dependent on low level modules.
     * If we want to change password reminder for another database, then code change is required.
     * It violates the OCP as well as ISP.
     */
    private static void badExample() {
        PassReminder passReminder = new PassReminder(new MySQLCon());
        System.out.println("Connection message: " + passReminder.getConnectionStatus());
    }

    /**
     * This is good example as high level modules and low level modules are not tightly coupled, they are dependent on abstraction.
     * We can just pass the new database object in password reminder constructor for other database connection messages.
     */
    private static void goodExample() {
        PasswordReminder mySqlPasswordReminder = new PasswordReminder(new MySQLConnection());
        PasswordReminder postgresSqlPasswordReminder = new PasswordReminder(new PostgresSQLConnection());
        System.out.println("MySQL connection message: " + mySqlPasswordReminder.getConnectionMessage());
        System.out.println("PostgresSQL connection message: " + postgresSqlPasswordReminder.getConnectionMessage());
    }

}

//////////////////////////////////// BAD EXAMPLE //////////////////////////////////////////
class MySQLCon {
    public String connect() {
        return "Connection established";
    }
}

class PassReminder {
    private final MySQLCon dbCon;

    public PassReminder(MySQLCon dbCon) {
        this.dbCon = dbCon;
    }

    public String getConnectionStatus() {
        return this.dbCon.connect();
    }
}


//////////////////////////////////// GOOD EXAMPLE //////////////////////////////////////////
interface DBConnection {
    String connect();
}

class MySQLConnection implements DBConnection {
    @Override
    public String connect() {
        return "MySQL Connection Established";
    }
}

class PostgresSQLConnection implements DBConnection {
    @Override
    public String connect() {
        return "PostgresSQL Connection Established";
    }
}

class PasswordReminder {
    private final DBConnection dbConnection;

    public PasswordReminder(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public String getConnectionMessage() {
        return this.dbConnection.connect();
    }
}