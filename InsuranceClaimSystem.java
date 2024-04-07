import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class InsuranceClaimSystem {
    private static final String CUSTOMERS_FILE = "customers.txt";
    private static final String INSURANCE_CARDS_FILE = "insurance_cards.txt";
    private static final String CLAIMS_FILE = "claims.txt";

    private static List<Customer> customers;
    private static List<InsuranceCard> insuranceCards;
    private static List<Claim> claims;

    public static void main(String[] args) {
        loadData(); // Load data from files

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("=== Insurance Claim System ===");
            System.out.println("1. View All Claims");
            System.out.println("2. Add a Claim");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    viewAllClaims();
                    break;
                case 2:
                    addClaim(scanner);
                    break;
                case 3:
                    saveData(); // Save data to files before exiting
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 3);
    }

    private static void loadData() {
        customers = readCustomersFromFile(CUSTOMERS_FILE);
        insuranceCards = readInsuranceCardsFromFile(INSURANCE_CARDS_FILE, customers);
        claims = readClaimsFromFile(CLAIMS_FILE, insuranceCards);
    }

    private static void saveData() {
        saveCustomersToFile(customers, CUSTOMERS_FILE);
        saveInsuranceCardsToFile(insuranceCards, INSURANCE_CARDS_FILE);
        saveClaimsToFile(claims, CLAIMS_FILE);
    }

    private static void viewAllClaims() {
        System.out.println("All Claims:");
        for (Claim claim : claims) {
            System.out.println(claim);
        }
    }

    private static void addClaim(Scanner scanner) {
        scanner.nextLine(); // Consume newline character
        System.out.println("Enter claim details:");

        System.out.print("Claim ID: ");
        String id = scanner.nextLine();

        System.out.print("Claim Date (yyyy-MM-dd): ");
        String claimDateString = scanner.nextLine();
        Date claimDate = parseDate(claimDateString);

        System.out.print("Insured Person: ");
        String insuredPerson = scanner.nextLine();

        System.out.print("Card Number: ");
        String cardNumber = scanner.nextLine();

        System.out.print("Exam Date (yyyy-MM-dd): ");
        String examDateString = scanner.nextLine();
        Date examDate = parseDate(examDateString);

        System.out.print("Claim Amount: ");
        double claimAmount = scanner.nextDouble();

        System.out.print("Status: ");
        String status = scanner.next();

        // Create a new claim object
        Claim claim = new Claim(id, claimDate, insuredPerson, cardNumber, examDate, new ArrayList<>(), claimAmount, status, null);

        // Add the claim to the list
        claims.add(claim);

        // Save data to files
        saveData();

        System.out.println("Claim added successfully.");
    }

    private static Date parseDate(String dateString) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd format.");
            return null;
        }
    }

    private static List<Customer> readCustomersFromFile(String filename) {
        // Implement reading customers from file
        return new ArrayList<>();
    }

    private static List<InsuranceCard> readInsuranceCardsFromFile(String filename, List<Customer> customers) {
        // Implement reading insurance cards from file
        return new ArrayList<>();
    }

    private static List<Claim> readClaimsFromFile(String filename, List<InsuranceCard> insuranceCards) {
        // Implement reading claims from file
        return new ArrayList<>();
    }

    private static void saveCustomersToFile(List<Customer> customers, String filename) {
        // Implement saving customers to file
    }

    private static void saveInsuranceCardsToFile(List<InsuranceCard> insuranceCards, String filename) {
        // Implement saving insurance cards to file
    }

    private static void saveClaimsToFile(List<Claim> claims, String filename) {
        // Implement saving claims to file
    }
}
