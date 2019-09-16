package com.dkatalis.assessment.optimalpath;

import com.dkatalis.assessment.optimalpath.util.Spf4jConfig;
import org.spf4j.perf.MeasurementRecorder;

import java.util.*;

public class Graph {

    List<List<Edge>> adj = new ArrayList<>();

    public Graph(List<Edge> edges, int N) {
        for (int i = 0; i < N; i++) {
            adj.add(i, new ArrayList<>());
        }

        for (Edge e : edges) {
            adj.get(e.src).add(Edge.of(e.src, e.dest, e.weight));
            adj.get(e.dest).add(Edge.of(e.dest, e.src, e.weight));
        }
    }

    public int calculateMaxBFS(Graph g, int src, int k, int destNode) {
        long startTime = System.currentTimeMillis();
        MeasurementRecorder measurementRecorder = Spf4jConfig.getMeasurementRecorder(App.class + " calculateMaxBFS");

        Queue<Node> q = new ArrayDeque<>();

        Set<Integer> vertices = new HashSet<>();
        vertices.add(0);
        q.add(new Node(src, 0, vertices));

        int maxCost = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            Node node = q.poll();

            int v = node.vertex;
            int cost = node.weight;
            vertices = new HashSet<>(node.s);

            if (cost > k) {
                maxCost = Math.max(maxCost, cost);
                if(node.vertex == destNode) {
                    break;
                }
            }

            for (Edge edge : g.adj.get(v)) {
                if (!vertices.contains(edge.dest)) {
                    Set<Integer> s = new HashSet<>(vertices);
                    s.add(edge.dest);
                    q.add(new Node(edge.dest, cost + edge.weight, s));
                }
            }
        }

        measurementRecorder.record(System.currentTimeMillis() - startTime);
        return maxCost;
    }
}
