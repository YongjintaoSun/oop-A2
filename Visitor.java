import java.time.LocalDate;

/**
 * Visitor class: Inherits from Person, manages theme park ride visitor information
 */
public class Visitor extends Person {
    // 2 exclusive instance variables (tailored to visitor scenarios: ticketing and visit time)
    private String ticketId;     // Ticket ID (unique for tracking)
    private LocalDate visitDate; // Visit date (for sorting and history records)

    // 1. Default constructor (calls parent class default constructor)
    public Visitor() {
        super();
        this.ticketId = "TICKET-UNDEFINED";
        this.visitDate = LocalDate.now(); // Default to current date
    }

    // 2. Parameterized constructor (initializes all parent + subclass variables)
    public Visitor(String personId, String name, LocalDate birthDate, 
                  String ticketId, LocalDate visitDate) {
        super(personId, name, birthDate); // Calls parent class parameterized constructor
        this.ticketId = ticketId;
        this.visitDate = visitDate;
    }

    // Full getters and setters
    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    // Override toString: Integrates information for easy printing of queues and history records
    @Override
    public String toString() {
        return "Visitor{" +
                "personInfo=" + super.toString() +
                ", ticketId='" + ticketId + '\'' +
                ", visitDate=" + visitDate +
                '}';
    }
}