package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        System.out.println("Timing table for addLast");
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        int a = 1000;
        for (int i = 0; i < 8; i += 1) {
            Ns.addLast(a);
            a *= 2;
        }
        for (int i = 0; i < Ns.size(); i += 1) {
            int n = Ns.get(i);
            Stopwatch sw = new Stopwatch();
            AList<Integer> list = new AList<>();
            for (int j = 0; j < n; j += 1) {
                list.addLast(1);
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
        }
        printTimingTable(Ns, times, Ns);
    }
}
