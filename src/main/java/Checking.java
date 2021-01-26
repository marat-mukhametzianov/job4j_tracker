import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Checking {
    public static void printCrossEl(int[] left, int[] right) {
        Arrays.stream(left)
                .filter(value -> Arrays.stream(right)
                        .anyMatch(x -> value == x)
                )
                .forEach(value -> System.out.println(value));
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {2, 7, 9, 3};
        Checking.printCrossEl(a, b);
    }
}
