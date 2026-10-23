## Project: Parking garage

### Q1. Actors
4 actors: management (tariffs), the cashier (payments), accounting (daily report), and the IT team (log file).

### Q2. Code review

| Principle | Class | Line(s) | Smell |
|---|---|---|---|
| SRP | ParkingGarage | 12-51 | fees, payments, report and logging in one class |
| OCP | ParkingGarage | 13-18 | switch on the vehicle type |
| LSP | CashPayment | 11-13 | refund throws UnsupportedOperationException |
| ISP | PaymentMethod | 6 | refund forced on every payment method |
| DIP | ParkingGarage | 9 | new FileLogger("parking.log") |

### Q3. Files to edit
a. ParkingGarage, Main
b. new MobileWalletPayment, Main
c. ParkingGarage, FileLogger, Main
d. ParkingGarage

### Q4. Removing instanceof
The program crashes with UnsupportedOperationException when cancelling the cash payment.
CashPayment breaks LSP because it cannot do what PaymentMethod promises.
The instanceof is not a fix because ParkingGarage must know every subclass (breaks OCP).

### Q5. Test without parking.log
ParkingGarage creates its FileLogger itself with new, so we cannot replace it.

### Q8. Cancelling a cash payment
It does not compile, because cancel takes a RefundablePaymentMethod and CashPayment is not one.
In Q4 the error only appeared at runtime.

### Q9. Test double
A fake: InMemoryReceiptLog, which keeps the receipts in a list instead of a file.

### Q10. Change requests
For all four (BusTariff, MobileWalletPayment, DatabaseReceiptLog, CsvReportFormatter) I only added a new class. No existing file, except Main.
