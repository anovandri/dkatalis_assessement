package com.dkatalis.assessment.optimalpath;

import java.util.Set;

public class Node {

    int vertex, weight;

    Set<Integer> s;

    Node(int vertex, int weight, Set<Integer> s) {
        this.vertex = vertex;
        this.weight = weight;
        this.s = s;
    }
}
