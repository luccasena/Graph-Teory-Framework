package io.github.luccasena.models;

import lombok.Getter;

import java.util.*;

public class BreadthFirstSearch {

    @Getter
    private final Set<Vertex> visitados;

    private final Map<Vertex, Vertex> predecessores;

    public BreadthFirstSearch() {
        this.visitados = new LinkedHashSet<>();
        this.predecessores = new HashMap<>();
    }

    public void executarBFS(Graph grafo, Vertex origem) {

        visitados.clear();
        predecessores.clear();

        Queue<Vertex> fila = new LinkedList<>();

        visitados.add(origem);
        fila.offer(origem);

        predecessores.put(origem, null);

        while (!fila.isEmpty()) {

            Vertex atual = fila.poll();

            int indiceAtual = grafo.getVertexIndices().get(atual.getValue());
            for (int j = 0; j < grafo.getQuantityVertex(); j++) {

                if (grafo.getMatrix()[indiceAtual][j] != 0) {
                    Vertex vizinho = getVertexByIndex(grafo, j);

                    if (!visitados.contains(vizinho)) {
                        visitados.add(vizinho);
                        predecessores.put(vizinho, atual);
                        fila.offer(vizinho);
                    }
                }
            }
        }
    }

    private Vertex getVertexByIndex(Graph grafo, int indice) {

        for (Map.Entry<String,Integer> entry : grafo.getVertexIndices().entrySet()) {
            if (entry.getValue() == indice)
                return grafo.getVerticeByLabel(entry.getKey());

        }

        return null;
    }

    public void imprimirCaminho(Vertex destino) {

        if (!visitados.contains(destino)) {
            IO.println("Não existe caminho entre os vértices.");
            return;
        }

        List<Vertex> caminho = new ArrayList<>();

        Vertex atual = destino;

        while (atual != null) {

            caminho.add(atual);

            atual = predecessores.get(atual);

        }

        Collections.reverse(caminho);

        IO.println("Menor caminho:");

        for (int i = 0; i < caminho.size(); i++) {

            IO.print(caminho.get(i).getValue());

            if (i != caminho.size() - 1)
                IO.print(" -> ");

        }

        IO.println();

    }

}