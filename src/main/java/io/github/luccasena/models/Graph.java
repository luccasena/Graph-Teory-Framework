package io.github.luccasena.models;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Graph {
    private Map<String, Vertex> vertices;
    private Map<String, Integer> vertexIndices;
    private Integer quantityVertex;
    private int[][] matrix;

    public Graph() {
        this.quantityVertex = 0;
        this.vertices = new HashMap<>();
        this.vertexIndices = new HashMap<>();
    }

    public void addVertex(Vertex vertex) {
        this.quantityVertex +=  1;
        vertexIndices.put(vertex.getValue(),this.quantityVertex - 1);
        this.vertices.put(vertex.getValue(), vertex);
        generateAdjacencyMatrix();
    }

    public void addEdge(String firstVertex, String secondVertex) {
        if (this.vertices.containsKey(firstVertex) && this.vertices.containsKey(secondVertex)) {
            Vertex vertex1 = this.vertices.get(firstVertex);
            Vertex vertex2 = this.vertices.get(secondVertex);

            int indexLine = vertexIndices.get(firstVertex);
            int indexColumn = vertexIndices.get(secondVertex);

            this.matrix[indexLine][indexColumn] += 1;
            this.matrix[indexColumn][indexLine] += 1;

            vertex1.setDegree(vertex1.getDegree() + 1);
            vertex2.setDegree(vertex2.getDegree() + 1);

        } else {
            IO.println("Vertice não encontrado");

        }
    }

    public void generateAdjacencyMatrix() {
        if (this.matrix == null) {
            Integer quantityVertex = this.quantityVertex;
            this.matrix = new int[quantityVertex][quantityVertex];

        } else {
            if (quantityVertex != this.matrix.length) {

                int [][] auxMatrix = this.matrix;
                int tamAuxMatrix = auxMatrix.length;
                this.matrix = new int[quantityVertex][quantityVertex];

                for (int i = 0; i < tamAuxMatrix; i++) {
                    System.arraycopy(auxMatrix[i], 0, this.matrix[i], 0, tamAuxMatrix);
                }

            }
        }
    }

    public void printMatrix() {

        for (int i = 0; i < quantityVertex; i++) {
            for (int j = 0; j < quantityVertex; j++) {
                IO.print(this.matrix[i][j]+"\t");
            }
            IO.println();
        }
    }

    public void printVertices(){

        this.vertices.forEach((_, vertex) -> IO.println("Vertices: "+vertex.getValue()+" | Degree: "+vertex.getDegree()));

    }

}
