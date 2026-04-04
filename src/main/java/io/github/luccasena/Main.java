package io.github.luccasena;


import io.github.luccasena.models.Graph;
import io.github.luccasena.models.Vertex;

public class Main {
    static void main() {
        Graph graph = new Graph();

        graph.addVertex(new Vertex("V1"));
        graph.addVertex(new Vertex("V2"));
        graph.addVertex(new Vertex("V3"));

        graph.addEdge("V1", "V2");
        graph.addEdge("V2", "V3");
        graph.addEdge("V1", "V3");

        graph.printMatrix();
        IO.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        graph.addVertex(new Vertex("V4"));
        graph.addVertex(new Vertex("V5"));
        graph.addVertex(new Vertex("V6"));

        graph.addEdge("V1", "V4");
        graph.addEdge("V2", "V5");
        graph.addEdge("V3", "V6");

        graph.printMatrix();
        IO.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        graph.printVertices();


    }
}
