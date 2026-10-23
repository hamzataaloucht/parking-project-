package parking.refactored;

public interface Tariff {
    String vehicleType();
    double fee(int hours);
}
