package Week_3.task1_solid;

// Class 4: Only logs audit events
public class AuditLogger {
    public void log(String action) {
        System.out.println("[AUDIT] " + action);
    }
}
