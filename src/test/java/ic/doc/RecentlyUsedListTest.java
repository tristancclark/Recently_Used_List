package ic.doc;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RecentlyUsedListTest {

  @Test
  public void listInitialisedAsEmpty() {
    assertTrue(new RecentlyUsedList<Integer>().size() == 0);
  }

  @Test
  public void canAddItems() {
    List<Integer> list = new RecentlyUsedList<>();
    assertTrue(list.add(new Integer(5)));
  }

  @Test
  public void doesNotAllowAddingAtIndexOtherThanZero() {
    List<Integer> list = new RecentlyUsedList<>();
    list.add(new Integer(5));
    list.add(new Integer(2));
    list.add(new Integer(1));
    try {
      list.add(2, new Integer(3));
    } catch (IndexOutOfBoundsException e) {
    }
  }

  @Test
  public void canRetrieveFromList() {
    List<Integer> list = new RecentlyUsedList<>();
    list.add(new Integer(5));
    list.add(new Integer(2));
    list.add(new Integer(1));
    list.add(new Integer(4));
    assertThat(list.get(0), is(4));
    assertThat(list.get(1), is(1));
    assertThat(list.get(2), is(2));
    assertThat(list.get(3), is(5));
  }

  @Test
  public void cannotAddDuplicates() {
    List<Integer> list = new RecentlyUsedList<>();
    list.add(new Integer(5));
    list.add(new Integer(5));
    list.add(new Integer(5));
    list.add(new Integer(6));
    list.add(new Integer(6));
    list.add(new Integer(7));
    assertThat(list.size(), is(3));
  }


  @Test
  public void worksForAnyObject() {
    List<String> list = new RecentlyUsedList<>();
    list.add("Hello");

    List<List<Integer>> listOuter = new RecentlyUsedList<>();
    List<Integer> listInner = new RecentlyUsedList<>();
    listOuter.add(listInner);
  }


}
