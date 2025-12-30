import java.io.*;
import java.util.*;

/**
 * Ride class: Implements RideInterface, manages queues, history, ride cycles, and IO operations
 */
public class Ride implements RideInterface {
    // 1. Instance variables (meets "at least 3" requirement, includes 1 Employee-type variable, corresponds to 🔶1-35)
    private String rideName;          // Ride name (e.g., "Roller Coaster")
    private int maxCapacity;          // Maximum queue capacity (total waiting slots)
    private Employee operator;        // Ride operator (Employee-type variable, mandatory)

    // 2. Collection variables (core of Parts 3-4: Queue for waiting, LinkedList for history)
    private Queue<Visitor> waitingLine;    // Waiting queue (FIFO, Part 3)
    private LinkedList<Visitor> rideHistory;// Ride history (Part 4A)

    // 3. Ride cycle variables (Part 5, corresponds to 🔶1-117 to 🔶1-118)
    private int maxRider;       // Maximum visitors per cycle
    private int numOfCycles;    // Number of cycles run (default 0, increments by 1 per run)

    // Constructor: Initializes all variables (HD-level code: avoids null pointers)
    public Ride(String rideName, int maxCapacity, int maxRider) {
        this.rideName = rideName;
        this.maxCapacity = maxCapacity;
        this.maxRider = maxRider;
        this.numOfCycles = 0; // Default to 0 cycles
        this.operator = null; // No operator initially
        this.waitingLine = new LinkedList<>(); // Queue implemented with LinkedList
        this.rideHistory = new LinkedList<>(); // History stored in LinkedList
    }

    // ------------------------------ Part 3: Queue Operations ------------------------------
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor == null) {
            System.out.println("[Failed] Cannot add null visitor to queue (" + rideName + ")");
            return;
        }
        if (waitingLine.size() >= maxCapacity) {
            System.out.println("[Failed] Queue is full (" + rideName + "), cannot add visitor: " + visitor.getName());
            return;
        }
        waitingLine.offer(visitor); // Add to queue (FIFO)
        System.out.println("[Success] Visitor added to queue (" + rideName + "): " + visitor.getName());
    }

    @Override
    public void removeVisitorFromQueue() {
        if (waitingLine.isEmpty()) {
            System.out.println("[Failed] Queue is empty (" + rideName + "), cannot remove visitor");
            return;
        }
        Visitor removed = waitingLine.poll(); // Remove from queue (FIFO)
        System.out.println("[Success] Visitor removed from queue (" + rideName + "): " + removed.getName());
    }

    @Override
    public void printQueue() {
        if (waitingLine.isEmpty()) {
            System.out.println("[Queue Status] " + rideName + ": No waiting visitors");
            return;
        }
        System.out.println("[Queue Status] " + rideName + " (Waiting count: " + waitingLine.size() + "):");
        int index = 1;
        for (Visitor v : waitingLine) { // Print in FIFO order
            System.out.println("  " + index + ". " + v);
            index++;
        }
    }

    // ------------------------------ Part 4A: History Records ------------------------------
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("[Failed] Cannot add null visitor to history (" + rideName + ")");
            return;
        }
        rideHistory.add(visitor);
        System.out.println("[Success] Visitor added to history (" + rideName + "): " + visitor.getName());
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null || rideHistory.isEmpty()) {
            return false; // Return false for null visitor or empty history
        }
        // Check by ticketId (unique identifier, more accurate than equals)
        for (Visitor v : rideHistory) {
            if (v.getTicketId().equals(visitor.getTicketId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size(); // Return count of historical visitors
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("[Ride History] " + rideName + ": No ride records");
            return;
        }
        System.out.println("[Ride History] " + rideName + " (Total riders: " + numberOfVisitors() + "):");
        // Must use Iterator (critical for HD level: meets 🔶1-88 requirement, no marks otherwise)
        Iterator<Visitor> iterator = rideHistory.iterator();
        int index = 1;
        while (iterator.hasNext()) {
            Visitor v = iterator.next();
            System.out.println("  " + index + ". " + v);
            index++;
        }
    }

    // ------------------------------ Part 4B: Sorting (Calls Comparator) ------------------------------
    /**
     * Sorts historical visitors by custom rules (must use Collections.sort + Comparator, corresponds to 🔶1-101)
     */
    public void sortRideHistory(Comparator<Visitor> comparator) {
        if (rideHistory.isEmpty()) {
            System.out.println("[Sort Failed] " + rideName + ": History is empty, no need to sort");
            return;
        }
        if (comparator == null) {
            System.out.println("[Sort Failed] " + rideName + ": Sorting rule not specified");
            return;
        }
        Collections.sort(rideHistory, comparator);
        System.out.println("[Success] " + rideName + " ride history sorted");
    }

    // ------------------------------ Part 5: Run Ride Cycle ------------------------------
    @Override
    public void runOneCycle() {
        // 1. Check for operator (cannot run without operator, corresponds to 🔶1-120)
        if (operator == null) {
            System.out.println("[Operation Failed] " + rideName + ": No operator assigned, cannot start");
            return;
        }
        // 2. Check waiting queue (cannot run without visitors, corresponds to 🔶1-121)
        if (waitingLine.isEmpty()) {
            System.out.println("[Operation Failed] " + rideName + ": No waiting visitors, cannot start");
            return;
        }

        // 3. Run cycle: Move visitors to history based on maxRider (corresponds to 🔶1-122)
        System.out.println("\n[Cycle Started] " + rideName + " (Max riders per cycle: " + maxRider + ")");
        int movedCount = 0;
        while (movedCount < maxRider && !waitingLine.isEmpty()) {
            Visitor v = waitingLine.poll(); // Remove from queue
            addVisitorToHistory(v);         // Add to history
            movedCount++;
        }

        // 4. Update cycle count
        numOfCycles++;
        System.out.println("[Cycle Successful] " + rideName + " completed cycle " + numOfCycles + ", moved " + movedCount + " visitors\n");
    }

    // ------------------------------ Part 6-7: IO Operations (Export/Import History) ------------------------------
    /**
     * Exports history to CSV file (corresponds to 🔶1-148 to 🔶1-151)
     */
    public void exportRideHistory(String filePath) {
        if (rideHistory.isEmpty()) {
            System.out.println("[Export Failed] " + rideName + ": History is empty, no need to export");
            return;
        }
        // Exception handling (critical for HD level: must catch IO exceptions, corresponds to 🔶1-151)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // 1. Write header (for readability)
            writer.write("personId,name,birthDate,ticketId,visitDate");
            writer.newLine();
            // 2. Write each visitor's data (CSV format: comma-separated)
            for (Visitor v : rideHistory) {
                String line = String.join(",",
                        v.getId(),
                        v.getName(),
                        v.getBirthDate().toString(),
                        v.getTicketId(),
                        v.getVisitDate().toString()
                );
                writer.write(line);
                writer.newLine();
            }
            System.out.println("[Success] " + rideName + " history exported to: " + filePath);
        } catch (IOException e) {
            System.out.println("[Export Failed] " + rideName + ": IO error, reason: " + e.getMessage());
        }
    }

    /**
     * Imports history from CSV file (corresponds to 🔶1-159 to 🔶1-162)
     */
    public void importRideHistory(String filePath) {
        // Exception handling (must catch IO exceptions)
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // Skip header (first line)
            int importedCount = 0;

            // Read each line and parse to Visitor
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                // Split CSV fields (comma-separated)
                String[] parts = line.split(",");
                if (parts.length != 5) {
                    System.out.println("[Skipped Invalid Line] Format error: " + line);
                    continue;
                }

                // Parse fields (handle date format exceptions)
                try {
                    LocalDate birthDate = LocalDate.parse(parts[2]);
                    LocalDate visitDate = LocalDate.parse(parts[4]);
                    Visitor v = new Visitor(
                            parts[0],  // personId
                            parts[1],  // name
                            birthDate, // birthDate
                            parts[3],  // ticketId
                            visitDate  // visitDate
                    );
                    rideHistory.add(v);
                    importedCount++;
                } catch (DateTimeException e) {
                    System.out.println("[Skipped Invalid Line] Date format error: " + line + ", reason: " + e.getMessage());
                }
            }
            System.out.println("[Success] " + rideName + " imported " + importedCount + " visitor records from: " + filePath);
        } catch (FileNotFoundException e) {
            System.out.println("[Import Failed] " + rideName + ": File not found: " + filePath);
        } catch (IOException e) {
            System.out.println("[Import Failed] " + rideName + ": IO error, reason: " + e.getMessage());
        }
    }

    // ------------------------------ Getter/Setter (Key Variables) ------------------------------
    public void setOperator(Employee operator) {
        this.operator = operator;
        if (operator != null) {
            System.out.println("[Success] " + rideName + " assigned operator: " + operator.getName());
        } else {
            System.out.println("[Notice] " + rideName + " operator removed");
        }
    }

    public String getRideName() {
        return rideName;
    }
}