package module.two.bbst.assignment;

import java.util.List;
import java.util.ArrayList;

/**
 * Queue Recontruction By Height:
 * <p>
 * You are given an array of people, people, which are the attributes of some people in a queue (not necessarily in order).
 * Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people in front who have a height
 * greater than or equal to hi.
 * <p>
 * Reconstruct and return the queue that is represented by the input array people. The returned queue should be formatted as an
 * array queue, where queue[j] = [hj, kj] is the attributes of the jth person in the queue (queue[0] is the person at the front
 * of the queue).
 * <p>
 * Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 * <p>
 * Input: people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
 * Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
 * <p>
 * Constraints:
 * 1 <= people.length <= 2000
 * 0 <= hi <= 10^6
 * 0 <= ki < people.length
 * It is guaranteed that the queue can be reconstructed.
 */
public class _1QueueByHeight {

    public static void main(String[] args) {
        List<List<Integer>> queue = new ArrayList<>(List.of(List.of(7, 0), List.of(4, 4), List.of(7, 1), List.of(5, 0),
                List.of(6, 1), List.of(5, 2)));
        System.out.println("Queue by height: " + queueByHeight(queue));
    }

    /**
     * Approach:
     * - The approach is simple, just sort the queue by height in descending order and for same height sort by people in front
     * in ascending order.
     * - Now, we have a sorted queue, just add the people in new list where index is the people in front.
     * - Time complexity: O(N*log(N)) due to sorting logic.
     * - Space complexity: O(N) due to new list.
     */
    private static List<List<Integer>> queueByHeight(List<List<Integer>> queue) {
        queue.sort((person1, person2) -> (!person1.get(0).equals(person2.get(0))) ? person2.get(0) - person1.get(0) :
                person1.get(1) - person2.get(1));
        System.out.println("Sorted by height: " + queue);
        List<List<Integer>> queueByHeight = new ArrayList<>();
        for (List<Integer> person : queue) {
            queueByHeight.add(person.get(1), person);
        }
        return queueByHeight;
    }

}