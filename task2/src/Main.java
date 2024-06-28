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

        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> pairs = new ArrayList<>();
        input.forEach(n -> {
            int remainder = Math.abs(13-n);
            if(map.get(remainder) != null) {
                for(int i=0; i<map.get(remainder); i++) {
                    pairs.add(List.of(Collections.min(List.of(n, remainder)),
                            Collections.max(List.of(n, remainder))));
                }
            }
            map.merge(n, 1, Integer::sum);
        });
        pairs.stream()
                .sorted(Comparator.comparingInt(n -> n.get(0)))
                .forEach(p -> System.out.println(p.get(0) + " " + p.get(1)));
    }
}