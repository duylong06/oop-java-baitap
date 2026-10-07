/*
 * BAI 3 - ABSTRACTION + INTERFACE (Truu tuong)
 * Cong thanh toan don hang
 *
 * Y tuong: interface = ban hop dong (neu VIEC phai lam duoc,
 * khong neu CACH lam). Order chi goi pay(), khong can biet ben trong
 * la the tin dung hay vi dien tu -> doi implementation ma KHONG sua Order.
 */

interface PaymentMethod {
    boolean pay(double amount);
    String getPaymentDetails();
}

class CreditCardPayment implements PaymentMethod {
    private String cardNumber;
    private String cardHolder;
    private double creditLimit;

    public CreditCardPayment(String cardNumber, String cardHolder, double creditLimit) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean pay(double amount) {
        if (amount > creditLimit) {
            return false;
        }
        creditLimit -= amount;
        return true;
    }

    @Override
    public String getPaymentDetails() {
        return "The tin dung: " + cardNumber + " | Chu the: " + cardHolder
             + " | Han muc con: " + creditLimit;
    }
}

class EWalletPayment implements PaymentMethod {
    private String phoneNumber;
    private double walletBalance;

    public EWalletPayment(String phoneNumber, double walletBalance) {
        this.phoneNumber = phoneNumber;
        this.walletBalance = walletBalance;
    }

    @Override
    public boolean pay(double amount) {
        if (amount <= walletBalance) {
            walletBalance -= amount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getPaymentDetails() {
        return "So dien thoai: " + phoneNumber + " | So du vi: " + walletBalance;
    }
}

class Order {
    private String orderId;
    private double totalAmount;
    private PaymentMethod paymentMethod;   // kieu la INTERFACE, khong phai class cu the

    public Order(String orderId, double totalAmount) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
    }

    // Giong nhu "rut quat ra, cam den vao" - o cam khong doi
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void checkout() {
        boolean ketQua = paymentMethod.pay(totalAmount);
        if (ketQua) {
            System.out.println("Don " + orderId + ": thanh toan THANH CONG " + totalAmount);
        } else {
            System.out.println("Don " + orderId + ": thanh toan THAT BAI");
        }
        System.out.println(paymentMethod.getPaymentDetails());
    }
}

public class Bai3_Interface {
    public static void main(String[] args) {
        Order order = new Order("DH001", 2000);

        // Lan 1: thanh toan bang the tin dung (han muc 5000 -> du)
        order.setPaymentMethod(new CreditCardPayment("1234", "Long", 5000));
        order.checkout();

        System.out.println();

        // Lan 2: thanh toan bang vi dien tu (so du 1500 -> khong du)
        // Class Order KHONG sua mot dong nao
        order.setPaymentMethod(new EWalletPayment("0909", 1500));
        order.checkout();
    }
}
