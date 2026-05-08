package Week_3;

// Class 3: Only sends emails
public class EmailNotifier implements Notifier {
    @Override
    public void send(String report, String recipient) {
        System.out.println("Emailing '" + report + "' to " + recipient);
    }
}
