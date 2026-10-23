package parking.refactored;

public class MobileWalletPayment implements RefundablePaymentMethod {
    private final String phoneNumber;

    public MobileWalletPayment(String phoneNumber) { this.phoneNumber = phoneNumber; }

    @Override
    public String name() { return "WALLET"; }

    @Override
    public void pay(double amount) {
        System.out.println("[WALLET " + phoneNumber + "] paid " + amount + " MAD");
    }

    @Override
    public void refund(double amount) {
        System.out.println("[WALLET " + phoneNumber + "] refunded " + amount + " MAD");
    }
}
