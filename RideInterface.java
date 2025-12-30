/**
 * Ride interface: Defines all mandatory core behaviors (enforces Ride class functionality)
 */
public interface RideInterface {
    // 1. Queue operations (Part 3)
    void addVisitorToQueue(Visitor visitor);    // Add visitor to queue
    void removeVisitorFromQueue();              // Remove visitor from queue (FIFO)
    void printQueue();                          // Print all visitors in queue

    // 2. History record operations (Part 4A)
    void addVisitorToHistory(Visitor visitor);  // Add visitor to ride history
    boolean checkVisitorFromHistory(Visitor visitor); // Check if visitor exists in history
    int numberOfVisitors();                     // Return number of visitors in history
    void printRideHistory();                    // Print historical visitors (using Iterator)

    // 3. Ride cycle (Part 5)
    void runOneCycle();                         // Run the ride for one cycle
}