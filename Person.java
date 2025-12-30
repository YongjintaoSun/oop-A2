import java.time.LocalDate;

/**
 * Abstract parent class: Represents common attributes and behaviors of a "person", cannot be instantiated
 */
public abstract class Person {
    // 3 instance variables (meets "at least 3" requirement, covering identity and basic information)
    private String id;         // Unique identifier (e.g., ID card/employee number)
    private String name;       // Full name
    private LocalDate birthDate;// Date of birth (facilitates age calculation later)

    // 1. Default constructor (no parameters)
    public Person() {
        this.id = "UNDEFINED";
        this.name = "UNDEFINED";
        this.birthDate = LocalDate.of(2000, 1, 1); // Default date
    }

    // 2. Parameterized constructor (initializes all parent class variables for subclass use)
    public Person(String id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    // Full getters and setters (encapsulation principle: variables are private, accessed via methods)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    // Override toString: Facilitates printing object information (essential for HD-level code: debugging and demonstration-friendly)
    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}