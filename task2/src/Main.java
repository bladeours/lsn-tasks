import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("provide input: ");
        Scanner scanner = new Scanner(System.in);
        List<Integer> input = null;
        try {
            input = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException ex) {
            System.out.println("invalid input");
            System.exit(-1);
        }

        Set<Integer> set = new HashSet<>();
        List<List<Integer>> pairs = new ArrayList<>();
        input.forEach(n -> {
            if(set.contains(Math.abs(13 - n))) {
                pairs.add(List.of(Collections.min(List.of(n, Math.abs(13 - n))),
                        Collections.max(List.of(n, Math.abs(13 - n)))));
            }
            set.add(n);
        });
        pairs.stream()
                .sorted(Comparator.comparingInt(n -> n.get(0)))
                .forEach(p -> System.out.println(p.get(0) + " " + p.get(1)));
    }
}