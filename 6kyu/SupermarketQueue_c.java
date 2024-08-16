
import java.util.Collections;
import java.util.PriorityQueue;

public class SupermarketQueue_c {
    public static void main(String[] args) {
        System.out.println(solveSuperMarketQueue(new int[] { 10, 2, 3, 3 }, 2));
    }
    // public static int solveSuperMarketQueue(int[] customers, int n) {
    //     if (n < 1 || customers.length == 0) return 0;
    //     int[] tills = IntStream.range(0, n).map(i -> 0).toArray();
    //     for (int i = 0; i < customers.length; i++) {
    //         Arrays.sort(tills);
    //         tills[0] += customers[i];
    //     }
    //     Arrays.sort(tills);
    //     return tills[tills.length - 1];
    // }

    public static int solveSuperMarketQueue(int[] customers, int n) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.nCopies(n, 0));
        for (int customer : customers) {
            queue.add(queue.poll() + customer);
            System.out.println(queue);
        }
        return Collections.max(queue);
    }
    
}
