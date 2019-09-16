package com.dkatalis.assessment.optimalpath;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Test_App {

    @Test
    public void test_calculateMaxBFS() {
        List<Edge> edges = Arrays.asList(Edge.of(0, 6, 11), Edge.of(0, 1, 5),
                Edge.of(1, 6, 3), Edge.of(1, 5, 5),
                Edge.of(1, 2, 7), Edge.of(2, 3, -8),
                Edge.of(3, 4, 10), Edge.of(5, 2, -1),
                Edge.of(5, 3, 9), Edge.of(5, 4, 1),
                Edge.of(6, 5, 2), Edge.of(7, 6, 9),
                Edge.of(7, 1, 6)
        );

        int N = 9;

        Graph g = new Graph(edges, N);

        int src = 0;
        int cost = 0;

        int maxCost = g.calculateMaxBFS(g, src, cost, 8);

        Assert.assertEquals(51, maxCost);
    }
}
