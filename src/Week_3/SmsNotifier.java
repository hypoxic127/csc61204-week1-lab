package Week_3;

public class SmsNotifier implements Notifier {
    @Override
    public void send(String report, String recipient) {
        System.out.println("Sending SMS '" + report + "' to " + recipient);
    }
}
