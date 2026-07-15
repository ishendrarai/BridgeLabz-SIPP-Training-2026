import java.util.ArrayDeque;
import java.util.Deque;

public class PrintQueueWithRushJobSupport {
    Deque<Integer> printQueue = new ArrayDeque<>();

    void submitJob(int jobId) {
        printQueue.addLast(jobId); // normal job: joins the back of the line
    }

    void submitUrgentJob(int jobId) {
        printQueue.addFirst(jobId); // urgent job: jumps to the front
    }

    int printNextJob() {
        return printQueue.removeFirst(); // printer always takes from the front
    }
}
