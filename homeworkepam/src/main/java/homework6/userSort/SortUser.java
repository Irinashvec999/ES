package homework6.userSort;
import java.util.Comparator;
import java.util.List;

public interface SortUser {
    void sort(List<User> users, Comparator<? super User>... comparators);
}
