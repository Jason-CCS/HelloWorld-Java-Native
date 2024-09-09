package com.jason.hack_rank;

import java.util.*;

/**
 * The program is implementing Breadth-First Search (BFS) algorithm on a graph,
 * calculating the shortest path distance from a specified source node to all other nodes in the graph,
 * with each edge having a cost.
 * If a node cannot be reached, the distance is flagged as -1. The graph is undirected and not necessarily connected.
 */
public class ShortestReach {

    /**
     * Time Complexity is O(n).
     * @param n
     * @param m
     * @param edges
     * @param s
     * @return
     */
    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        // Write your code here
        Node root = new Node(s);
        Graph graph = new Graph(root);
        TreeSet<Node> set = new TreeSet<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.key, o2.key);
            }
        });

        for (int i = 1; i <= n; i++) {
            graph.addNode(i);
        }

        set.addAll(graph.nodes.values());

        for (List<Integer> edge : edges) {
            graph.addEdge(edge.get(0), edge.get(1));
        }

        helper(root);

        List<Integer> result = new ArrayList<>();
        for (Node node : set) {
            if(node.key != s){
                result.add(node.distance);
            }
        }

        return result;
    }

    public static void helper(Node root) {
        Queue<Node> queue = new LinkedList<>();
        root.marked = true;
        queue.offer(root);
        int level = 0;


        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            // visit
            if (currentNode != root) {
                level = currentNode.level;
                currentNode.distance = currentNode.level * 6;
            }
            // traverse
            for (Node neighbor : currentNode.getNeighbors()) {
                if (!neighbor.marked) {
                    neighbor.marked = true;
                    neighbor.level = level + 1;
                    queue.offer(neighbor);
                }
            }
        }
    }


    static class Node {
        public int key;
        public List<Node> neighbors;
        public boolean marked;
        public int level;
        public int distance = -1;

        public Node(int key) {
            this.key = key;
            neighbors = new LinkedList<>();
        }

        public void addChild(Node child) {
            neighbors.add(child);
        }

        public List<Node> getNeighbors() {
            return neighbors;
        }

        @Override
        public String toString() {
            return String.format("key=%d", key);
        }
    }

    static class Graph {
        public Node root;
        public HashMap<Integer, Node> nodes;

        public Graph(Node root) {
            this.root = root;
            this.nodes = new HashMap<>();
            this.nodes.put(root.key, root);
        }

        public void addEdge(int fromKey, int toKey) {
            Node fromNode = nodes.get(fromKey);
            Node toNode = nodes.get(toKey);
            if (fromNode == null) {
                fromNode = new Node(fromKey);
            }
            if (toNode == null) {
                toNode = new Node(toKey);
            }
            fromNode.addChild(toNode);
            toNode.addChild(fromNode);
            this.nodes.put(fromKey, fromNode);
            this.nodes.put(toKey, toNode);
        }

        public Node getNode(int key) {
            return nodes.get(key);
        }

        public void addNode(int key) {
            if (!nodes.containsKey(key)) {
                this.nodes.put(key, new Node(key));
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(1, 3));
        edges.add(Arrays.asList(3, 4));

        bfs(5, 3, edges, 1);

    }
}
