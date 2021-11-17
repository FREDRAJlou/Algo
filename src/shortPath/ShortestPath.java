package shortPath;

import java.util.*;
import java.util.stream.Collectors;

class Node {
    int val;
    int dist;

    public Node(int val, int dist) {
        this.val = val;
        this.dist = dist;
    }
}

class Graph {
    int size = 0;
    int[] nodes;
    Map<Integer, LinkedList<Node>> edges;

    public Graph(int size) {
        nodes = new int[size];
        edges = new HashMap<>();
    }

    void addNodes(int[] node) {
        this.nodes = node;
        for (int i : nodes) {
            edges.put(i, new LinkedList<>());
        }
    }

    void addEdges(int from, Node to) {
        edges.get(from).add(to);
    }
}

public class ShortestPath {
    public static void main(String[] a) {
     /*   Graph g = new Graph(7);
        g.addNodes(new int[]{1, 2, 3, 4, 5, 6, 7});
        g.addEdges(1, new Node(2, 7));
        g.addEdges(2, new Node(3, 2));
        g.addEdges(3, new Node(4, 5));
        g.addEdges(4, new Node(5, 18));
        g.addEdges(5, new Node(6, 1));
        g.addEdges(1, new Node(6, 23));
        g.addEdges(4, new Node(6, 2));
        g.addEdges(6, new Node(5, 2));
        g.addEdges(7, new Node(5, 2));*/
        Graph g = new Graph(9);
        g.addNodes(new int[]{1, 2, 3, 4, 5, 6, 7,8,9});
        g.addEdges(1, new Node(7, 11));
        g.addEdges(1, new Node(8, 50));
        g.addEdges(1, new Node(2, 10));
        g.addEdges(1, new Node(4, 5));
        g.addEdges(1, new Node(9, 12));
        g.addEdges(2, new Node(3, 5));
        g.addEdges(2, new Node(5, 2));
        g.addEdges(2, new Node(7, 5));
        g.addEdges(3, new Node(6, 2));
        g.addEdges(3, new Node(8, 4));
        g.addEdges(4, new Node(3, 4));
        g.addEdges(4, new Node(8, 3));
        g.addEdges(5, new Node(3, 2));
        g.addEdges(5, new Node(4, 2));
        g.addEdges(6, new Node(2, 1));
        g.addEdges(6, new Node(1, 7));
        g.addEdges(9, new Node(8, 10));
        int src = 3;
        Arrays.stream(g.nodes).forEach(node -> System.out.println(node + " -> " + String.join(", ", g.edges.get(node).stream().map(n -> n.val + " " + n.dist).collect(Collectors.toList()))));
        Map<Integer, Integer> shortestPath = getShortPath(g, src);
        shortestPath.keySet().stream().forEach(n -> System.out.println(src + " to " + n + " = " + shortestPath.get(n)));
    }

    private static Map<Integer, Integer> getShortPath(Graph g, int src) {
        Map<Integer, Integer> shortestPath = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < g.nodes.length; i++) {
            shortestPath.put(g.nodes[i], Integer.MAX_VALUE);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        shortestPath.put(src, 0);
        while (!q.isEmpty() && visited.size() < g.nodes.length) {
            int node = q.poll();
            if (!visited.contains(node)) {
                visited.add(node);
                int min = Integer.MAX_VALUE;
                int dist = shortestPath.get(node);
                for (Node n : g.edges.get(node)) {
                    /*if (n.dist < min) {
                        min = n.dist;
                        q.clear();
                        q.add(n.val);
                    }*/
                    if (dist + n.dist < shortestPath.get(n.val)) {
                        shortestPath.replace(n.val, dist + n.dist);
                        if(visited.contains(n.val))
                            visited.remove(n.val);
                        q.add(n.val);
                    }
                }
            }
        }
        return shortestPath;
    }
}
