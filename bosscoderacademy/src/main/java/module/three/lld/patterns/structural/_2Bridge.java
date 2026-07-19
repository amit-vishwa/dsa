package module.three.lld.patterns.structural;

/**
 * Bridge lets you change "How" something works without changing "What" it does.
 * Bridge decouples an abstraction from its implementation so that the two can vary independently, it separates "what" something
 * does from "how" it does.
 * <p>
 * Why This Is a Better Bridge Example:
 * - Application hierarchy can grow independently
 * - DatabaseEngine hierarchy can grow independently
 * <p>
 * You can combine:
 * ReportingApp + MySQL
 * ReportingApp + PostgresSQL
 * BankingApp + MySQL
 * BankingApp + Oracle
 * <p>
 * without creating:
 * ReportingAppMySQL
 * ReportingAppPostgres
 * BankingAppMySQL
 * <p>
 * That’s the core idea of Bridge.
 */
public class _2Bridge {

    public static void main(String[] args) {
        Application mySQLApp = new ReportingApplication(new MySQLDatabase());
        Application postgresSQLApp = new ReportingApplication(new PostgresSQLDatabase());
        mySQLApp.run();
        postgresSQLApp.run();
    }

}

// abstraction hierarchy
interface DatabaseEngine {
    void connect();
}

class MySQLDatabase implements DatabaseEngine {

    @Override
    public void connect() {
        System.out.println("Connected to MySQL database");
    }

}

class PostgresSQLDatabase implements DatabaseEngine {

    @Override
    public void connect() {
        System.out.println("Connected to PostgresSQL database");
    }

}

// implementation hierarchy
abstract class Application {
    protected DatabaseEngine engine;

    public Application(DatabaseEngine engine) {
        this.engine = engine;
    }

    abstract void run();
}

class ReportingApplication extends Application {
    public ReportingApplication(DatabaseEngine engine) {
        super(engine);
    }

    @Override
    public void run() {
        this.engine.connect();
        System.out.println("Generating reports...");
    }
}