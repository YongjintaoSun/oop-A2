import java.time.LocalDate;

/**
 * Main class: Demonstrates implementation of all Part functionalities to verify code correctness
 */
public class AssignmentTwo {
    // Main method: Program entry point, calls all demonstration methods
    public static void main(String[] args) {
        AssignmentTwo demo = new AssignmentTwo();
        System.out.println("==================================== Part 3: Queue Operations ====================================");
        demo.partThree();

        System.out.println("\n==================================== Part 4A: Ride History ====================================");
        demo.partFourA();

        System.out.println("\n==================================== Part 4B: History Sorting ====================================");
        demo.partFourB();

        System.out.println("\n==================================== Part 5: Run Ride Cycle ====================================");
        demo.partFive();

        System.out.println("\n==================================== Part 6: Export History ====================================");
        demo.partSix();

        System.out.println("\n==================================== Part 7: Import History ====================================");
        demo.partSeven();
    }

    // ------------------------------ Part 3: Demonstrate Queue Operations (Add 5, Remove 1, Print) ------------------------------
    public void partThree() {
        // 1. Create ride (Roller Coaster, max queue capacity 10, max riders per cycle 2)
        Ride rollerCoaster = new Ride("Roller Coaster", 10, 2);

        // 2. Create 5 visitors (meets "at least 5" requirement)
        Visitor v1 = new Visitor("P001", "Jack", LocalDate.of(2000, 1, 1), "T001", LocalDate.now());
        Visitor v2 = new Visitor("P002", "Sharon", LocalDate.of(2002, 2, 2), "T002", LocalDate.now());
        Visitor v3 = new Visitor("P003", "Benny", LocalDate.of(1998, 3, 3), "T003", LocalDate.now());
        Visitor v4 = new Visitor("P004", "Leo", LocalDate.of(2005, 4, 4), "T004", LocalDate.now());
        Visitor v5 = new Visitor("P005", "Nehemia", LocalDate.of(1995, 5, 5), "T005", LocalDate.now());

        // 3. Add 5 visitors to queue
        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);

        // 4. Print queue (after adding)
        System.out.println("\n[Part 3] Queue after adding 5 visitors:");
        rollerCoaster.printQueue();

        // 5. Remove 1 visitor
        rollerCoaster.removeVisitorFromQueue();

        // 6. Print queue (after removal)
        System.out.println("\n[Part 3] Queue after removing 1 visitor:");
        rollerCoaster.printQueue();
    }

    // ------------------------------ Part 4A: Demonstrate History Records (Add 5, Check, Print) ------------------------------
    public void partFourA() {
        Ride thunderstorm = new Ride("Thunderstorm", 10, 4);

        // 1. Create 5 visitors
        Visitor v1 = new Visitor("P006", "Tom", LocalDate.of(1999, 6, 6), "T006", LocalDate.now());
        Visitor v2 = new Visitor("P007", "Sherly", LocalDate.of(2001, 7, 7), "T007", LocalDate.now());
        Visitor v3 = new Visitor("P008", "Ben", LocalDate.of(2003, 8, 8), "T008", LocalDate.now());
        Visitor v4 = new Visitor("P009", "David", LocalDate.of(1997, 9, 9), "T009", LocalDate.now());
        Visitor v5 = new Visitor("P010", "Lee", LocalDate.of(2004, 10, 10), "T010", LocalDate.now());

        // 2. Add 5 visitors to history
        thunderstorm.addVisitorToHistory(v1);
        thunderstorm.addVisitorToHistory(v2);
        thunderstorm.addVisitorToHistory(v3);
        thunderstorm.addVisitorToHistory(v4);
        thunderstorm.addVisitorToHistory(v5);

        // 3. Check if visitor exists in history (exists)
        Visitor checkV = new Visitor("P007", "Sherly", LocalDate.of(2001, 7, 7), "T007", LocalDate.now());
        boolean exists = thunderstorm.checkVisitorFromHistory(checkV);
        System.out.println("[Part 4A] Is visitor Sherly in history: " + (exists ? "Yes" : "No"));

        // 4. Print number of historical visitors
        System.out.println("[Part 4A] Total historical visitors: " + thunderstorm.numberOfVisitors());

        // 5. Print history records (using Iterator)
        System.out.println("[Part 4A] History details:");
        thunderstorm.printRideHistory();
    }

    // ------------------------------ Part 4B: Demonstrate History Sorting (Add 5, Sort, Compare) ------------------------------
    public void partFourB() {
        Ride ferrisWheel = new Ride("Ferris Wheel", 10, 3);
        VisitorComparator comparator = new VisitorComparator(); // Custom comparator

        // 1. Create 5 visitors (different visit dates for sorting)
        Visitor v1 = new Visitor("P011", "Alice", LocalDate.of(2000, 11, 11), "T011", LocalDate.of(2024, 10, 1));
        Visitor v2 = new Visitor("P012", "Bob", LocalDate.of(1990, 12, 12), "T012", LocalDate.of(2024, 10, 1)); // Same date, older age
        Visitor v3 = new Visitor("P013", "Charlie", LocalDate.of(1995, 1, 13), "T013", LocalDate.of(2024, 10, 2));
        Visitor v4 = new Visitor("P014", "Diana", LocalDate.of(2002, 2, 14), "T014", LocalDate.of(2024, 10, 3));
        Visitor v5 = new Visitor("P015", "Eve", LocalDate.of(1985, 3, 15), "T015", LocalDate.of(2024, 10, 2));

        // 2. Add to history
        ferrisWheel.addVisitorToHistory(v1);
        ferrisWheel.addVisitorToHistory(v2);
        ferrisWheel.addVisitorToHistory(v3);
        ferrisWheel.addVisitorToHistory(v4);
        ferrisWheel.addVisitorToHistory(v5);

        // 3. Print history before sorting
        System.out.println("[Part 4B] History before sorting:");
        ferrisWheel.printRideHistory();

        // 4. Sort (using custom Comparator)
        ferrisWheel.sortRideHistory(comparator);

        // 5. Print history after sorting (verify sorting effect)
        System.out.println("\n[Part 4B] History after sorting (visit date ascending → age descending):");
        ferrisWheel.printRideHistory();
    }

    // ------------------------------ Part 5: Demonstrate Ride Cycle (Add 10, Run, Compare) ------------------------------
    public void partFive() {
        // 1. Create ride and operator
        Ride logFlume = new Ride("Log Flume", 20, 3); // Max 3 riders per cycle
        Employee operator = new Employee(
                "E001", "Mike", LocalDate.of(1985, 6, 6), 
                "EMP-001", "Morning Shift"
        );
        logFlume.setOperator(operator); // Assign operator (mandatory, cannot run without)

        // 2. Create 10 visitors (meets "at least 10" requirement)
        Visitor[] visitors = new Visitor[10];
        for (int i = 0; i < 10; i++) {
            visitors[i] = new Visitor(
                    "P" + String.format("%03d", 16 + i), 
                    "Visitor" + (16 + i), 
                    LocalDate.of(2000 + i, 1, 1), 
                    "T" + String.format("%03d", 16 + i), 
                    LocalDate.now()
            );
            logFlume.addVisitorToQueue(visitors[i]); // Add to queue
        }

        // 3. Print queue before cycle
        System.out.println("[Part 5] Queue before cycle:");
        logFlume.printQueue();

        // 4. Run one cycle
        logFlume.runOneCycle();

        // 5. Print queue after cycle (3 fewer visitors)
        System.out.println("[Part 5] Queue after cycle:");
        logFlume.printQueue();

        // 6. Print history after cycle (3 more visitors)
        System.out.println("[Part 5] History after cycle:");
        logFlume.printRideHistory();
    }

    // ------------------------------ Part 6: Demonstrate Export History to CSV ------------------------------
    public void partSix() {
        Ride bumperCars = new Ride("Bumper Cars", 10, 2);

        // 1. Add 5 visitors to history
        for (int i = 0; i < 5; i++) {
            Visitor v = new Visitor(
                    "P" + String.format("%03d", 26 + i), 
                    "ExportVisitor" + (26 + i), 
                    LocalDate.of(1995 + i, 1, 1), 
                    "T" + String.format("%03d", 26 + i), 
                    LocalDate.now()
            );
            bumperCars.addVisitorToHistory(v);
        }

        // 2. Export to CSV (customizable path, using "bumper_cars_history.csv" here)
        String exportPath = "bumper_cars_history.csv";
        bumperCars.exportRideHistory(exportPath);
    }

    // ------------------------------ Part 7: Demonstrate Import History from CSV ------------------------------
    public void partSeven() {
        Ride importedRide = new Ride("Imported Bumper Cars", 10, 2);

        // 1. Import from Part 6's CSV file (path must match Part 6)
        String importPath = "bumper_cars_history.csv";
        importedRide.importRideHistory(importPath);

        // 2. Verify import result: Print visitor count
        System.out.println("[Part 7] Number of visitors after import: " + importedRide.numberOfVisitors());

        // 3. Verify import result: Print details
        System.out.println("[Part 7] History after import:");
        importedRide.printRideHistory();
    }
}