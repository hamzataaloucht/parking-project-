package parking.refactored;

import java.util.List;

public class CsvReportFormatter implements ReportFormatter {
    @Override
    public String formatReceipt(Receipt receipt) {
        return receipt.plate() + "," + receipt.vehicleType() + "," + receipt.hours() + ","
                + receipt.amount() + "," + receipt.paymentMethod();
    }

    @Override
    public String formatDailyReport(List<Receipt> receipts, double total) {
        StringBuilder sb = new StringBuilder("plate,type,hours,amount,payment\n");
        for (Receipt receipt : receipts) {
            sb.append(formatReceipt(receipt)).append("\n");
        }
        sb.append("TOTAL,,,").append(total).append(",");
        return sb.toString();
    }
}
