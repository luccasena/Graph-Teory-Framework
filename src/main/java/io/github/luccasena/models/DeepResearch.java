package io.github.luccasena.models;

import lombok.Getter;

import java.util.*;

public class DeepResearch {
    @Getter
    private Set<Vertex> visitados;
    private final Map<Vertex, Vertex> predecessores;

    public DeepResearch() {
        this.visitados = new LinkedHashSet<>(); // LinkedHashSet evita elementos duplicados e preserva a ordem em que os vértices foram visitados.
        this.predecessores = new HashMap<>();
    }

    public void executarDFS(Vertex vertex) {
        this.visitados.clear();
        predecessores.clear();
        predecessores.put(vertex, null);
        buscar(vertex);
    }

    private void buscar(Vertex vertex) {
        visitados.add(vertex);
        for(Vertex adjacente: vertex.getNeighborhood()) {
            if(!visitados.contains(adjacente)) {
                predecessores.put(adjacente, vertex);
                buscar(adjacente);
            }
        }

    }

    public void printDeepResearch(Vertex destino) {
        if (!visitados.contains(destino)) {
            System.out.println("Não existe caminho.");
            return;
        }

        List<Vertex> caminho = new ArrayList<>();

        Vertex atual = destino;

        while (atual != null) {
            caminho.add(atual);
            atual = predecessores.get(atual);
        }

        Collections.reverse(caminho);

        for (Vertex v : caminho) {
            System.out.print(v.getValue());

            if (!v.equals(destino))
                System.out.print(" -> ");
        }
    }

}
