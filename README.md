# Amusement Park Ride Management System

A Java-based application designed to manage amusement park rides, including queue operations, visitor history tracking, ride cycle simulation, and data persistence.

## Overview
This system provides a comprehensive solution for managing amusement park rides, with core functionalities focused on visitor flow control, historical data management, and operational simulation. It follows object-oriented design principles (OOP) to ensure modularity, reusability, and scalability.

## Core Features
- **Queue Management**: Add/remove visitors from ride queues (FIFO logic) and print queue status.
- **Visitor History**: Record, query, and count visitors who have ridden the attraction.
- **Custom Sorting**: Sort historical records by visit date (ascending) and age (descending) via a custom comparator.
- **Ride Cycle Simulation**: Run ride cycles to move visitors from the queue to history (based on max riders per cycle).
- **Data Persistence**: Export visitor history to CSV files and import historical data from CSV files.
- **Input Validation**: Handle edge cases (e.g., null visitors, full queues, missing files) with meaningful error messages.

## Prerequisites
- JDK 8 or higher (supports `LocalDate` and lambda expressions)
- Any Java IDE (IntelliJ IDEA, Eclipse) or command-line tools (javac, java)

## Installation & Usage
1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-username/amusement-park-ride-management.git
   cd amusement-park-ride-management
   ```

2. **Compile the Code**
   ```bash
   javac *.java
   ```

3. **Run the Application**
   ```bash
   java AssignmentTwo
   ```
   The main class (`AssignmentTwo`) will automatically demonstrate all core functionalities, including queue operations, history management, sorting, ride cycles, and CSV import/export.

## Class Structure
| Class Name          | Role & Responsibility                                                                 |
|---------------------|---------------------------------------------------------------------------------------|
| `Person`            | Abstract parent class encapsulating common attributes (ID, name, date of birth).       |
| `Visitor`           | Subclass of `Person` – adds visitor-specific data (ticket ID, visit date).             |
| `Employee`          | Subclass of `Person` – adds employee-specific data (employee ID, work shift).          |
| `RideInterface`     | Interface defining mandatory methods for ride management (queue, history, cycles).     |
| `Ride`              | Implements `RideInterface` – core class handling queue, history, cycles, and CSV IO.   |
| `VisitorComparator` | Custom comparator for sorting visitors by visit date and age.                          |
| `AssignmentTwo`     | Main class with demonstration code for all functionalities.                            |

## Key Technical Highlights
- **OOP Principles**: Abstraction (`Person`), inheritance (`Visitor`/`Employee`), encapsulation, and polymorphism.
- **Collection Framework**: Uses `Queue` (LinkedList) for FIFO queue management and `LinkedList` for history storage.
- **Custom Comparator**: Implements `Comparator<Visitor>` for flexible sorting logic.
- **File Handling**: Uses `BufferedReader`/`BufferedWriter` for CSV import/export with error handling.
- **Exception Handling**: Gracefully handles IO exceptions, null inputs, and boundary cases.

## Example Output
When running `AssignmentTwo`, you’ll see demonstrations of:
- Adding 5 visitors to a ride queue and removing 1.
- Recording 5 visitors in ride history and verifying a visitor’s presence.
- Sorting historical records by visit date and age.
- Running a ride cycle to move visitors from the queue to history.
- Exporting history to `bumper_cars_history.csv` and importing it back.

## License
This project is licensed under the MIT License – see the [LICENSE](LICENSE) file for details.

## Contributing
1. Fork the repository.
2. Create a feature branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -m 'Add your feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Open a Pull Request.

## Contact
For questions or feedback, feel free to reach out to [your-email@example.com] or open an issue in the repository.
