import java.util.*;

public class Main {
    private static final Set<Integer> visited = new HashSet<>();
    private static final Map<Integer, List<Integer>> graph = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            var input = scanner.nextLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            edges.add(List.of(a, b));
            putNeighborToGraph(a, b);
        }

        int count = 0;
        for(Integer e: edges.stream().flatMap(Collection::stream).toList()){
            if(!visited.contains(e)) {
                dfs(e);
                count++;
            }
        }
        System.out.println(count);

    }

    private static void putNeighborToGraph(int node, int neighbor) {
        if(graph.get(node) == null) {
            graph.put(node, new ArrayList<>(List.of(neighbor)));
        } else {
            graph.get(node).add(neighbor);
        }

        if(graph.get(neighbor) == null) {
            graph.put(neighbor, new ArrayList<>(List.of(node)));
        } else {
            graph.get(neighbor).add(node);
        }
    }

    private static void dfs(int node) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if(!visited.contains(current)) {
                visited.add(current);
                for (int neighbor: graph.get(current)) {
                    if(!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }
}