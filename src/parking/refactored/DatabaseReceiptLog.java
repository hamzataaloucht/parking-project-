package parking.refactored;

// no real database in this lab, it only shows the query it would run
public class DatabaseReceiptLog implements ReceiptLog {
    private final String table;

    public DatabaseReceiptLog(String table) { this.table = table; }

    @Override
    public void log(String line) {
        System.out.println("[DB] INSERT INTO " + table + " VALUES ('" + line + "')");
    }
}
