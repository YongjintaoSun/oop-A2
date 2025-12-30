import java.time.LocalDate;
import java.util.Comparator;

/**
 * Visitor comparator: Implements Comparator, sorts by "visit date + age" (meets "at least 2 variables" requirement)
 */
public class VisitorComparator implements Comparator<Visitor> {
    /**
     * Sorting rules:
     * 1. First by visit date (ascending: earlier visits come first)
     * 2. For same dates, by age (descending: older visitors come first)
     */
    @Override
    public int compare(Visitor v1, Visitor v2) {
        if (v1 == null || v2 == null) {
            throw new IllegalArgumentException("Visitor objects cannot be null");
        }

        // 1. Primary sorting dimension: Visit date (ascending)
        LocalDate date1 = v1.getVisitDate();
        LocalDate date2 = v2.getVisitDate();
        int dateCompare = date1.compareTo(date2);
        if (dateCompare != 0) {
            return dateCompare;
        }

        // 2. Secondary sorting dimension: Age (descending, calculated via date of birth)
        LocalDate birth1 = v1.getBirthDate();
        LocalDate birth2 = v2.getBirthDate();
        // Earlier birth date → older age → comes first (descending order)
        return birth2.compareTo(birth1);
    }
}