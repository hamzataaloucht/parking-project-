package parking.refactored;

import java.util.ArrayList;
import java.util.List;

public class ParkingService {
    private final List<Receipt> receipts = new ArrayList<>();
    private final ReceiptLog log;
    private final ReportFormatter formatter;
    private double total;

    public ParkingService(ReceiptLog log, ReportFormatter formatter) {
        this.log = log;
        this.formatter = formatter;
    }

    public double fee(Vehicle vehicle, int hours) {
        return vehicle.getTariff().fee(hours);
    }

    public void checkout(Vehicle vehicle, int hours, PaymentMethod method) {
        double amount = fee(vehicle, hours);
        method.pay(amount);
        total += amount;

        Receipt receipt = new Receipt(vehicle.getPlate(), vehicle.getTariff().vehicleType(),
                hours, amount, method.name());
        receipts.add(receipt);
        log.log(formatter.formatReceipt(receipt));
    }

    // only refundable methods are accepted here, cash goes through cancelAtDesk
    public void cancel(Vehicle vehicle, int hours, RefundablePaymentMethod method) {
        double amount = fee(vehicle, hours);
        method.refund(amount);
        total -= amount;
    }

    public void cancelAtDesk(Vehicle vehicle, int hours) {
        double amount = fee(vehicle, hours);
        System.out.println("Refund " + amount + " MAD at the desk for " + vehicle.getPlate());
        total -= amount;
    }

    public double getTotal() {
        return total;
    }

    public String dailyReport() {
        return formatter.formatDailyReport(receipts, total);
    }
}
