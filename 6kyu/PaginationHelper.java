/*
 For this exercise you will be strengthening your page-fu mastery. You will complete the PaginationHelper class, 
 which is a utility class helpful for querying paging information related to an array.

The class is designed to take in an array of values and an integer indicating how many items will be allowed per each page. 
The types of values contained within the collection/array are not relevant.

The following are some examples of how this class is used:

PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
helper.pageCount(); // should == 2
helper.itemCount(); // should == 6
helper.pageItemCount(0); // should == 4
helper.pageItemCount(1); // last page - should == 2
helper.pageItemCount(2); // should == -1 since the page is invalid

// pageIndex takes an item index and returns the page that it belongs on
helper.pageIndex(5); // should == 1 (zero based index)
helper.pageIndex(2); // should == 0
helper.pageIndex(20); // should == -1
helper.pageIndex(-10); // should == -1

 */

import java.util.List;

public class PaginationHelper<I> {

    public static void main(String[] args) {
        List<Character> collection = List.of('1', '2', '3', '4');
        PaginationHelper<Character> helper = new PaginationHelper<>(collection, 4);

        System.out.println(helper.pageCount());
        System.out.println(helper.itemCount());
        System.out.println(helper.pageItemCount(0));
        System.out.println(helper.pageItemCount(1));
        System.out.println(helper.pageItemCount(2));
        System.out.println();
        System.out.println(helper.pageIndex(3));
        System.out.println(helper.pageIndex(2));
        System.out.println(helper.pageIndex(20));
        System.out.println(helper.pageIndex(-10));
    }

    /**
     * The constructor takes in an array of items and a integer indicating how
     * many items fit within a single page
     */
    private List<I> _collection;
    private int _itemsPerPage;
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        _collection = collection;
        _itemsPerPage = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return _collection.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        int p = _collection.size() / _itemsPerPage;
        return (_collection.size() % _itemsPerPage > 0) ? p + 1 : p;
    }

    /**
     * returns the number of items on the current page. page_index is zero
     * based. this method should return -1 for pageIndex values that are out of
     * range
     */
    public int pageItemCount(int pageIndex) {
        int a = pageCount() - 1;
        if (pageIndex > a || pageIndex < 0) return -1;
        else if (pageIndex < a || _collection.size()%_itemsPerPage == 0) return _itemsPerPage;
        else return _collection.size()%_itemsPerPage;
    }

    /**
     * determines what page an item is on. Zero based indexes this method should
     * return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        int page = itemIndex / _itemsPerPage;
        return (itemIndex < 0 || itemIndex > itemCount() - 1) ? -1 : page;
    }
}
