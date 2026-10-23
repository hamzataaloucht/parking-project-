package parking.refactored;

public class TruckTariff implements Tariff {
    @Override
    public String vehicleType() {
        return "TRUCK";
    }

    @Override
    public double fee(int hours) {
        return 20 + hours * 10.0;
    }
}
