package parking.refactored;

public class ParkingServiceTest {
    private static int failures = 0;

    public static void main(String[] args) {
        InMemoryReceiptLog log = new InMemoryReceiptLog();
        ParkingService service = new ParkingService(log, new TextReportFormatter());

        Vehicle car   = new Vehicle("12345-A-6", new CarTariff());
        Vehicle bike  = new Vehicle("67890-B-1", new MotorbikeTariff());
        Vehicle truck = new Vehicle("24680-D-8", new TruckTariff());

        check("car fee for 3 h", 15.0, service.fee(car, 3));
        check("motorbike fee for 2 h", 4.0, service.fee(bike, 2));
        check("truck fee for 4 h", 60.0, service.fee(truck, 4));

        CardPayment card = new CardPayment("4242");
        service.checkout(car, 3, card);
        service.checkout(bike, 2, new CashPayment());
        service.checkout(truck, 4, card);

        check("total of the daily report", 79.0, service.getTotal());
        check("receipts logged", 3, log.getLines().size());

        if (!service.dailyReport().endsWith("Total: 79.0 MAD")) {
            System.out.println("FAIL: daily report does not end with the total");
            failures++;
        }

        System.out.println(failures == 0 ? "All tests passed" : failures + " test(s) failed");
    }

    private static void check(String name, double expected, double actual) {
        if (expected == actual) {
            System.out.println("OK: " + name);
        } else {
            System.out.println("FAIL: " + name + " expected " + expected + " but was " + actual);
            failures++;
        }
    }
}
