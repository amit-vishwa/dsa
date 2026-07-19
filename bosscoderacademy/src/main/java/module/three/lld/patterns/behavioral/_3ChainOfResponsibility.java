package module.three.lld.patterns.behavioral;

/**
 * Chain of Responsibility Pattern
 * <p>
 * Allows a request to be passed through a chain of handlers until one of them handles it.
 * Each handler decides whether it can process the request;
 * otherwise it forwards the request to the next handler in the chain.
 * <p>
 * Request -> Handler1 -> Handler2 -> Handler3 -> ... -> null
 * <p>
 * Example:
 * Support Ticket -> ChatBot -> L1 Support -> L2 Support -> Support Manager
 */
public class _3ChainOfResponsibility {

    public static void main(String[] args) {
        SupportHandler chatbotHandler = new ChatBotHandler();
        SupportHandler l1SupportHandler = new L1SupportHandler();
        SupportHandler l2SupportHandler = new L2SupportHandler();
        SupportHandler managerHandler = new ManagerHandler();

        chatbotHandler.setNext(l1SupportHandler);
        l1SupportHandler.setNext(l2SupportHandler);
        l2SupportHandler.setNext(managerHandler);
        managerHandler.setNext(new DefaultHandler());

        chatbotHandler.handle(new SupportTicket("Forgot password", Severity.LOW));
        chatbotHandler.handle(new SupportTicket("Payment failed", Severity.MEDIUM));
        chatbotHandler.handle(new SupportTicket("Application crashing repeatedly", Severity.HIGH));
        chatbotHandler.handle(new SupportTicket("Production system down", Severity.CRITICAL));
        chatbotHandler.handle(new SupportTicket("UI typo", Severity.UNKNOWN));
    }

}

enum Severity {
    LOW, MEDIUM, HIGH, CRITICAL, UNKNOWN;
}

class SupportTicket {
    private final String description;
    private final Severity severity;

    SupportTicket(String description, Severity severity) {
        this.description = description;
        this.severity = severity;
    }

    public String getDescription() {
        return this.description;
    }

    public Severity getSeverity() {
        return this.severity;
    }
}

interface SupportHandler {
    void setNext(SupportHandler next);

    void handle(SupportTicket ticket);
}

abstract class AbstractSupportHandler implements SupportHandler {
    protected SupportHandler next;

    @Override
    public void setNext(SupportHandler next) {
        this.next = next;
    }

    protected void forward(SupportTicket ticket) {
        if (this.next != null) {
            this.next.handle(ticket);
        }
    }
}

class DefaultHandler extends AbstractSupportHandler {
    @Override
    public void handle(SupportTicket ticket) {
        System.out.println("No handler available for ticket: " + ticket.getDescription());
    }
}

class ChatBotHandler extends AbstractSupportHandler {
    @Override
    public void handle(SupportTicket ticket) {
        if (ticket.getSeverity() == Severity.LOW) {
            System.out.println("ChatBot resolved: " + ticket.getDescription());
        } else {
            forward(ticket);
        }
    }
}

class L1SupportHandler extends AbstractSupportHandler {
    @Override
    public void handle(SupportTicket ticket) {
        if (ticket.getSeverity() == Severity.MEDIUM) {
            System.out.println("L1 Support resolved: " + ticket.getDescription());
        } else {
            forward(ticket);
        }
    }
}

class L2SupportHandler extends AbstractSupportHandler {
    @Override
    public void handle(SupportTicket ticket) {
        if (ticket.getSeverity() == Severity.HIGH) {
            System.out.println("L2 Support resolved: " + ticket.getDescription());
        } else {
            forward(ticket);
        }
    }
}

class ManagerHandler extends AbstractSupportHandler {
    @Override
    public void handle(SupportTicket ticket) {
        if (ticket.getSeverity() == Severity.CRITICAL) {
            System.out.println("Support Manager resolved: " + ticket.getDescription());
        } else {
            forward(ticket);
        }
    }
}