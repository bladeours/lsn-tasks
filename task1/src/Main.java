import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("provide input: ");
        Scanner scanner = new Scanner(System.in);
        List<Integer> input = null;
        try {
            input  = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException ex) {
            System.out.println("invalid input");
            System.exit(-1);
        }
        List<Integer> distinctAndSorted = input.stream().sorted().distinct().toList();
        System.out.println(distinctAndSorted.stream()
                                            .map(Object::toString)
                                            .collect(Collectors.joining(" ")));
        System.out.println("count: " + input.size());
        System.out.println("distinct: " + distinctAndSorted.size());
        System.out.println("min: " + Collections.min(distinctAndSorted));
        System.out.println("max: " + Collections.max(distinctAndSorted));
    }
}