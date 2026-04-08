package io.github.luccasena;


import io.github.luccasena.models.Graph;
import io.github.luccasena.models.Vertex;

public class Main {
    static void main() {
        Graph graph = new Graph(true);

        graph.addVertex(new Vertex("1"));
        graph.addVertex(new Vertex("2"));
        graph.addVertex(new Vertex("3"));
        graph.addVertex(new Vertex("4"));
        graph.addVertex(new Vertex("5"));
        graph.addVertex(new Vertex("6"));
        graph.addVertex(new Vertex("7"));

        graph.addEdge("1", "2");

        graph.addEdge("2", "4");
        graph.addEdge("2", "3");

        graph.addEdge("3", "1");

        graph.addEdge("4", "3");
        graph.addEdge("4", "1");

        graph.addEdge("5", "6");
        graph.addEdge("5", "7");

        graph.addEdge("6", "2");

        graph.addEdge("7", "4");
        graph.addEdge("7", "6");

        graph.printMatrix();
        IO.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        graph.printVertices();


    }
}
