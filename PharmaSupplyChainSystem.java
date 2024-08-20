import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Transaction {
    private String drugName;
    private String batchNumber;
    private String sender;
    private String receiver;
    private String timestamp;
    private String status;

    public Transaction(String drugName, String batchNumber, String sender, String receiver, String timestamp, String status) {
        this.drugName = drugName;
        this.batchNumber = batchNumber;
        this.sender = sender;
        this.receiver = receiver;
        this.timestamp = timestamp;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Drug: " + drugName + ", Batch: " + batchNumber + ", Sender: " + sender + ", Receiver: " + receiver + ", Timestamp: " + timestamp + ", Status: " + status;
    }
}

class SmartContract {
    private List<Transaction> blockchain;

    public SmartContract() {
        blockchain = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        blockchain.add(transaction);
        System.out.println("Transaction added: " + transaction);
    }

    public void viewTransactions() {
        System.out.println("\n--- Supply Chain Transactions ---");
        for (Transaction transaction : blockchain) {
            System.out.println(transaction);
        }
    }
}

public class PharmaSupplyChainSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static SmartContract contract = new SmartContract();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Pharma Supply Chain System ---");
            System.out.println("1. Add New Drug to Supply Chain");
            System.out.println("2. View Supply Chain Transactions");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addNewDrug();
                    break;
                case 2:
                    contract.viewTransactions();
                    break;
                case 3:
                    System.out.println("Exiting the system.");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void addNewDrug() {
        System.out.print("Enter drug name: ");
        String drugName = scanner.nextLine();
        System.out.print("Enter batch number: ");
        String batchNumber = scanner.nextLine();
        System.out.print("Enter sender (e.g., Manufacturer): ");
        String sender = scanner.nextLine();
        System.out.print("Enter receiver (e.g., Distributor): ");
        String receiver = scanner.nextLine();
        System.out.print("Enter timestamp (e.g., 2024-08-20 10:00:00): ");
        String timestamp = scanner.nextLine();
        System.out.print("Enter status (e.g., Dispatched, In Transit, Delivered): ");
        String status = scanner.nextLine();

        Transaction transaction = new Transaction(drugName, batchNumber, sender, receiver, timestamp, status);
        contract.addTransaction(transaction);
    }
}
