package parking.refactored;

import java.util.ArrayList;
import java.util.List;

// fake log used by the tests, keeps the lines in memory instead of writing a file
public class InMemoryReceiptLog implements ReceiptLog {
    private final List<String> lines = new ArrayList<>();

    @Override
    public void log(String line) {
        lines.add(line);
    }

    public List<String> getLines() {
        return lines;
    }
}
