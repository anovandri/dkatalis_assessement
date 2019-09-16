package com.dkatalis.assessment.optimalpath;

public class Edge {

    public final int src, dest, weight;

    private Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public static Edge of(int a, int b, int c) {
        return new Edge(a, b, c);
    }
}
