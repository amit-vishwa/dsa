package module.three.lld.patterns.structural;

/**
 * Adapter (also called as Wrapper) converts the interface of a class into another interface that client expects.
 * Its makes classes work together that are incompatible due to interfaces.
 * <p>
 * Real-World Analogy
 * This is like:
 * - UPI app = modern interface
 * - Bank core system = old incompatible backend
 * - Adapter = translator between them
 * That’s exactly what the Adapter pattern is meant for.
 */
public class _1Adapter {

    public static void main(String[] args) {
        DigitalPayment digitalPayment = new UPIAdapter(new LegacyBankAPI(), "user@upi");
        digitalPayment.makePayment(1000, "merchant@upi");
    }

}

interface DigitalPayment {
    void makePayment(double amount, String recipient);
}

class LegacyBankAPI {

    public void transferMoney(String fromAccount, String toAccount, double amount) {
        System.out.println("Transferred " + amount + " from " + fromAccount + " to " + toAccount);
    }

}

class UPIAdapter implements DigitalPayment {

    private final LegacyBankAPI legacyBankAPI;
    private final String upiId;

    public UPIAdapter(LegacyBankAPI legacyBankAPI, String upiId) {
        this.legacyBankAPI = legacyBankAPI;
        this.upiId = upiId;
    }

    @Override
    public void makePayment(double amount, String recipient) {
        // legacy bank api is used with digital payment where only 2 args are required
        this.legacyBankAPI.transferMoney(this.upiId, recipient, amount);
    }
}