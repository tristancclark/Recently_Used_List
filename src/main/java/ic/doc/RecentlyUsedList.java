package ic.doc;

import java.util.ArrayList;

public class RecentlyUsedList<E> extends ArrayList<E> {

  @Override
  public boolean add(E element) {
    try {
      if (contains(element)) {
        remove(element);
        add(0, element);
        return true;
      } else {
        add(0, element);
        return true;
      }
    } catch (IndexOutOfBoundsException e) {
      return false;
    }
  }

  @Override
  public void add(int index, E element) {
    if (index != 0) {
      throw new IndexOutOfBoundsException();
    } else {
      super.add(0, element);
    }
  }


}
