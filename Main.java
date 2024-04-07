import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Sample usage
        PolicyHolder policyHolder = new PolicyHolder("ph1", "John Doe", "1234567890", new ArrayList<>());
        Dependent dependent1 = new Dependent("d1", "Alice Doe", "0987654321", policyHolder);
        Dependent dependent2 = new Dependent("d2", "Bob Doe", "0987654321", policyHolder);
        List<Dependent> dependents = new ArrayList<>();
        dependents.add(dependent1);
        dependents.add(dependent2);
        policyHolder.setDependents(dependents);

        List<Claim> claims = new ArrayList<>();
        Claim claim1 = new Claim("f1", new Date(), "Alice Doe", "1234567890", new Date(), new ArrayList<>(), 100.0, "New", null);
        Claim claim2 = new Claim("f2", new Date(), "Bob Doe", "1234567890", new Date(), new ArrayList<>(), 200.0, "Processing", null);
        claims.add(claim1);
        claims.add(claim2);

        // Create a ClaimProcessManager implementation
        ClaimProcessManagerImpl claimProcessManager = new ClaimProcessManagerImpl();
        claimProcessManager.add(claim1);
        claimProcessManager.add(claim2);

        // Display all claims
        System.out.println("All Claims:");
        List<Claim> allClaims = claimProcessManager.getAll();
        for (Claim claim : allClaims) {
            System.out.println(claim);
        }

        // Sort claims by claim amount
        System.out.println("\nClaims Sorted by Amount:");
        List<Claim> sortedClaimsByAmount = claimProcessManager.getAllSortedByAmount();
        for (Claim claim : sortedClaimsByAmount) {
            System.out.println(claim);
        }

        // Save claims report to a text file
        try {
            saveClaimsReportToFile(allClaims, "claims_report.txt");
            System.out.println("\nClaims report saved to claims_report.txt");
        } catch (IOException e) {
            System.out.println("Error occurred while saving claims report: " + e.getMessage());
        }
    }

    public static void saveClaimsReportToFile(List<Claim> claims, String fileName) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("Claims Report");
            writer.println("-----------------------------------------------");
            writer.printf("%-15s %-20s %-15s %-15s %-15s %-15s %-15s %-15s\n", "ID", "Claim Date", "Insured Person", "Card Number", "Exam Date", "Claim Amount", "Status", "Banking Info");
            writer.println("-----------------------------------------------");
            for (Claim claim : claims) {
                String claimDateStr = dateFormat.format(claim.getClaimDate());
                String examDateStr = dateFormat.format(claim.getExamDate());
                String bankingInfo = claim.getReceiverBankingInfo() != null ? claim.getReceiverBankingInfo().toString() : "";
                writer.printf("%-15s %-20s %-15s %-15s %-15s %-15s %-15s %-15s\n",
                        claim.getId(), claimDateStr, claim.getInsuredPerson(), claim.getCardNumber(),
                        examDateStr, claim.getClaimAmount(), claim.getStatus(), bankingInfo);
            }
        }
    }
}

