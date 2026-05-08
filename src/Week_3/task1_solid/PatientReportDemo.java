package Week_3.task1_solid;

public class PatientReportDemo {
    public static void main(String[] args) {
        PatientReportFormatter formatter = new PatientReportFormatter();
        ReportFileSaver saver  = new ReportFileSaver();
        
        // Using Notifier interface - swapping between Email and SMS is easy without changing other code
        Notifier notifier = new SmsNotifier(); // Can be swapped to: new EmailNotifier();
        
        AuditLogger logger     = new AuditLogger();

        String report = formatter.format("Maria Santos", 80);
        saver.save(report, "report_001.txt");
        notifier.send(report, "doctor@meditrack.com"); // Re-used seamlessly
        logger.log("Report generated for Maria Santos");
    }
}
