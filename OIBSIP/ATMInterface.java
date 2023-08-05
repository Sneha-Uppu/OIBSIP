import java.util.Scanner;

public class ATMInterface {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] user = { 1234,5678,2468,1357,1000 };
        int[] pin = { 4321, 8765, 8642, 7531, 0001 };
        int[] balance = { 40000, 80000, 850000, 70000, 100000 };
        int attempt = 1, m = 0, n = 0, withdraw, deposit;
        try {
            System.out.println("Enter your user ID:");
            int userid = sc.nextInt();
            for (int i = 0; i < 5; i++) {
                if (userid != user[i]) {
                    attempt++;
                } else {
                    n = i;
                    attempt = 1;
                    break;
                }
            }
            if (attempt > 1) {
                System.out.println("Invalid User ID");
                return;
            }
            System.out.println("Welcome " + userid + " for ATM services.");
            System.out.println("Enter your PIN:");
            int pwd = sc.nextInt();
            if (pwd != pin[n]) {
                while (true) {
                    System.out.println("Entered PIN is incorrect.");
                    attempt++;
                    System.out.println("Re-enter your pin: ");
                    pwd = sc.nextInt();
                    if (pwd == pin[n]) {
                        break;
                    }
                    if (attempt >= 3) {
                        System.out.println("You've exceeded the limit. Please try again after some time.");
                        return;
                    }
                }
            }
            System.out.println();
            System.out.println("Choose your task.");
            System.out.println("1. Balance enquiry");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transaction");
            System.out.println("5. quit");
            System.out.println();
            System.out.println("Enter your option :");
            int opt = sc.nextInt();
            switch (opt) {
                case 1:
                    System.out.println("Transaction History");
                    System.out.println("Your current balance is:" + balance[n]);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw:");
                    withdraw = sc.nextInt();
                    if (withdraw > balance[n] || balance[n] == 0) {
                        System.out.println("Insufficient funds.");
                        System.out.println();
                        break;
                    }
                    System.out.println("Withdraw processed.");
                    balance[n] = balance[n] - withdraw;
                    System.out.println("Your current balance is:" + balance[n]);
                    break;
                case 3:
                    System.out.println("Enter amount to deposit:");
                    deposit = sc.nextInt();
                    balance[n] = balance[n] + deposit;
                    System.out.println("Your amount is deposited successfully.");
                    System.out.println("Your current balance is:" + balance[n]);
                    break;
                case 4:
                    System.out.println("Enter the user ID to which you want to transfer the amount");
                    int uid = sc.nextInt();
                    for (int i = 0; i < 5; i++) {
                        if (uid != user[i]) {
                            attempt++;
                        } else {
                            m = i;
                            attempt = 1;
                            break;
                        }
                    }
                    if (attempt > 1) {
                        System.out.println("Invalid User ID");
                        return;
                    }
                    System.out.println("Enter the amount that you would like to transfer");
                    int am = sc.nextInt();
                    balance[n] = balance[n] - am;
                    balance[m] = balance[m] + am;
                    System.out.println("Your current balance after transaction is:" + balance[n]);
                    break;
                case 5:
                    System.out.println("ThankYou for utilising ATM services.");
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid Option. Try again!!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        sc.close();
    }
}
