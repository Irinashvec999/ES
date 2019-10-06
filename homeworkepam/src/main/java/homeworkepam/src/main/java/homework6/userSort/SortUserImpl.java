package homework6.userSort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortUserImpl implements Comparator<User>, SortUser {
    private final List<Comparator> comparators;

    public SortUserImpl(List<Comparator> comparators) {
        this.comparators = comparators;
    }

    public SortUserImpl(Comparator<? super User>... comparators) {
        this(Arrays.asList(comparators));
    }

    @Override
    public int compare(User user1, User user2) {
        for (Comparator<User> c : comparators) {
            int result = c.compare(user1, user2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }

    @Override
    public void sort(List<User> users, Comparator<? super User>... comparators) {
        Collections.sort(users, new SortUserImpl(comparators));
    }
}
