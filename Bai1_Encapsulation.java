/*
 * BAI 1 - ENCAPSULATION (Dong goi)
 * Quan ly tai khoan ngan hang
 *
 * Y tuong: du lieu de private (khoa lai), chi mo ra vai method public
 * co kiem tra -> ben ngoai khong the sua balance truc tiep.
 */

class BankAccount {

    // ===== FIELD: private = "ket sat", ben ngoai khong dung toi duoc =====
    private String accountNumber;
    private String ownerName;
    private double balance;

    // ===== CONSTRUCTOR: tram gac dau tien, chan du lieu ban =====
    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;

        if (balance < 0) {
            this.balance = 0;
            System.out.println("Loi: So du ban dau khong hop le, da dat ve 0");
        } else {
            this.balance = balance;
        }
    }

    // ===== METHOD =====

    // void = lam xong thoi, khong bao lai ket qua
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Loi: So tien nap phai lon hon 0");
            return;                      // dung ngay, khong cong tien
        }
        balance += amount;
        System.out.println("Nap thanh cong: " + amount);
    }

    // boolean = phai bao lai thanh cong hay that bai
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Loi: So tien rut phai lon hon 0");
            return false;
        }
        if (amount > balance) {
            System.out.println("Loi: So du khong du de rut " + amount);
            return false;
        }
        balance -= amount;
        System.out.println("Rut thanh cong: " + amount);
        return true;
    }

    public void displayInfo() {
        System.out.println("So TK: " + accountNumber
                         + " | Chu TK: " + ownerName
                         + " | So du: " + balance);
    }
}

public class Bai1_Encapsulation {
    public static void main(String[] args) {

        // (1) Tao 2 tai khoan voi so du ban dau khac nhau
        BankAccount acc1 = new BankAccount("8386", "Long", 1000);
        BankAccount acc2 = new BankAccount("6789", "Hai", 2000);

        System.out.println("--- Thong tin ban dau ---");
        acc1.displayInfo();
        acc2.displayInfo();

        // (2) Thu nap tien am -> bi chan
        System.out.println("\n--- Thu nap -500 vao acc1 ---");
        acc1.deposit(-500);

        // (3) Thu rut vuot so du -> bi chan
        System.out.println("\n--- Thu rut 3000 tu acc2 ---");
        acc2.withdraw(3000);

        // (4) In so du cuoi cung -> van nguyen ven
        System.out.println("\n--- So du cuoi cung ---");
        acc1.displayInfo();
        acc2.displayInfo();
    }
}
