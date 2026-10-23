package parking.refactored;

import java.util.List;

public class TextReportFormatter implements ReportFormatter {
    @Override
    public String formatReceipt(Receipt receipt) {
        return receipt.plate() + " | " + receipt.vehicleType() + " | "
                + receipt.hours() + " h | " + receipt.amount() + " MAD | " + receipt.paymentMethod();
    }

    @Override
    public String formatDailyReport(List<Receipt> receipts, double total) {
        StringBuilder sb = new StringBuilder("=== Daily report ===\n");
        for (Receipt receipt : receipts) {
            sb.append(formatReceipt(receipt)).append("\n");
        }
        sb.append("Total: ").append(total).append(" MAD");
        return sb.toString();
    }
}
