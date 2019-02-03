package ic.doc;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.List;
import org.junit.Test;

public class RecentlyUsedListTest {

  @Test
  public void listInitialisedAsEmpty() {
    assertTrue(new RecentlyUsedList<Integer>().size() == 0);
  }

  @Test
  public void canAddItems() {
    List<Integer> list = new RecentlyUsedList<>();
    assertTrue(list.add(5));
  }

  @Test
  public void doesNotAllowAddingAtIndexOtherThanZero() {
    List<Integer> list = new RecentlyUsedList<>();
    list.add(5);
    list.add(2);
    list.add(1);
    try {
      list.add(2, 3);
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Index Out of Bounds Exception thrown as expected");
    }
  }

  @Test
  public void canRetrieveFromList() {
    List<Integer> list = new RecentlyUsedList<>();
    list.add(5);
    list.add(2);
    list.add(1);
    list.add(4);
    assertThat(list.get(0), is(4));
    assertThat(list.get(1), is(1));
    assertThat(list.get(2), is(2));
    assertThat(list.get(3), is(5));
  }

  @Test
  public void cannotAddDuplicates() {
    List<Integer> list = new RecentlyUsedList<>();
    list.add(5);
    list.add(5);
    list.add(5);
    list.add(6);
    list.add(6);
    list.add(7);
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
