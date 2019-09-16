package com.dkatalis.assessment.optimalpath;

import com.dkatalis.assessment.optimalpath.util.Spf4jConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class App {

    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        Spf4jConfig.initialize();

        List<Edge> edges = Arrays.asList(Edge.of(0, 1, 1), Edge.of(1, 2, 2), Edge.of(2,3, 2));

        int N = 9;

        Graph g = new Graph(edges, N);

        int src = 0;
        int cost = 0;
        int destNode = 3;

        int maxCost = g.calculateMaxBFS(g, src, cost, destNode);

        LOG.info(" Summary of cost is {} ", maxCost);

        System.exit(0);
    }
}

