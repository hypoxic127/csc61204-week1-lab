package Week_3;

// --- Interfaces for Abstraction (DIP & OCP) ---

interface NotificationService {
    void sendMessage(String message);
}

interface DatabaseService {
    void connect();
}

interface InsuranceCalculator {
    double calculate(double amount);
}

// --- Single Responsibility Classes (SRP) ---

class PatientAdmissions {
    public void admitPatient(String name) { 
        System.out.println("Admitting " + name);
    }
}

class InvoiceGenerator {
    public void generateInvoice(String name) { 
        System.out.println("Generating invoice for " + name);
    }
}

class ReportPrinter {
    public void printReport(String report) { 
        System.out.println("Printing: " + report);
    }
}

// Implementations of Interfaces

class SmsService implements NotificationService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class SqlDatabaseService implements DatabaseService {
    @Override
    public void connect() {
        System.out.println("Connecting to SQL Database...");
    }
}

class PremiumInsuranceCalculator implements InsuranceCalculator {
    @Override
    public double calculate(double amount) {
        return amount * 0.8; // Example logic
    }
}

class StandardInsuranceCalculator implements InsuranceCalculator {
    @Override
    public double calculate(double amount) {
        return amount * 0.9; // Example logic
    }
}

// --- Refactored HospitalSystem (Optional Facade) ---
// If a single entry point is still desired, it should delegate tasks
// instead of doing the work itself (Dependency Injection).
public class HospitalSystemRefactored {
    private PatientAdmissions admissions;
    private InvoiceGenerator invoiceGenerator;
    private NotificationService notifier;
    private DatabaseService db;
    private ReportPrinter printer;

    public HospitalSystemRefactored(
            PatientAdmissions admissions, 
            InvoiceGenerator invoiceGenerator, 
            NotificationService notifier, 
            DatabaseService db, 
            ReportPrinter printer) {
        this.admissions = admissions;
        this.invoiceGenerator = invoiceGenerator;
        this.notifier = notifier;
        this.db = db;
        this.printer = printer;
    }

    public void admitPatient(String name) {
        admissions.admitPatient(name);
    }

    public void generateInvoice(String name) {
        invoiceGenerator.generateInvoice(name);
    }

    public void notify(String message) {
        notifier.sendMessage(message);
    }
    
    // Insurance calculation is no longer hardcoded inside the system
    public double calculateInsurance(InsuranceCalculator calculator, double amount) {
        return calculator.calculate(amount);
    }
}
