package parking.refactored;

public class BusTariff implements Tariff {
    @Override
    public String vehicleType() {
        return "BUS";
    }

    @Override
    public double fee(int hours) {
        return hours * 15.0;
    }
}
