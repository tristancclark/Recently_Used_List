package ic.doc;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class RecentlyUsedList<E> extends ArrayList<E> {

    @Override
    public boolean add(E element) {
        try {
            if(contains(element)) {
                remove(element);
                add(0, element);
                return true;
            } else {
                 add(0, element);
                return true;
            }
        } catch(IndexOutOfBoundsException e) {
            return false;
        }
    }


}
