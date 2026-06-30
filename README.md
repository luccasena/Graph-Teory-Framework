# Graph Teory Framework

Projeto acadêmico em **Java** para representação de grafos e aplicação de algoritmos de busca. O grafo pode ser não direcionado ou direcionado, sendo representado principalmente por **matriz de adjacência**.

## Objetivo

Implementar estruturas e algoritmos básicos de grafos, com foco em:

- criação de vértices e arestas;
- representação por matriz de adjacência;
- busca em largura (**BFS**);
- busca em profundidade (**DFS**);
- reconstrução de caminho entre origem e destino.

## Tecnologias

- Java
- Gradle
- Lombok

## Estrutura

```text
src/main/java/io/github/luccasena/
├── Main.java
├── exceptions/
│   └── ResearchError.java
└── models/
    ├── Graph.java
    ├── Vertex.java
    ├── BreadthFirstSearch.java
    └── DeepResearch.java
```

## Principais classes

### `Graph`

Representa o grafo. Armazena os vértices, seus índices e a matriz de adjacência.

Principais métodos:

- `addVertex(Vertex vertex)`: adiciona um vértice ao grafo;
- `addEdge(String firstVertex, String secondVertex)`: adiciona uma aresta;
- `generateAdjacencyMatrix()`: cria ou redimensiona a matriz;
- `printMatrix()`: exibe a matriz de adjacência;
- `getVerticeByLabel(String label)`: busca um vértice pelo rótulo.

### `Vertex`

Representa um vértice do grafo.

Atributos principais:

- `value`: rótulo do vértice;
- `neighborhood`: lista de vizinhos;
- `degree`: grau do vértice.

### `BreadthFirstSearch`

Implementa a **Busca em Largura (BFS)**.

Principais métodos:

- `executarBFS(Graph grafo, Vertex origem)`: percorre o grafo a partir da origem;
- `imprimirCaminho(Vertex destino)`: reconstrói e exibe o menor caminho em quantidade de arestas.

A BFS é adequada quando o objetivo é encontrar o **menor caminho em número de arestas** em um grafo não ponderado.

### `DeepResearch`

Implementa a **Busca em Profundidade (DFS)**.

Principais métodos:

- `executarDFS(Vertex vertex)`: inicia a busca em profundidade;
- `printDeepResearch(Vertex destino)`: exibe um caminho encontrado até o destino.

A DFS percorre o grafo explorando o máximo possível cada ramo antes de retornar.

### `ResearchError`

Exceção personalizada usada quando não existe caminho entre os vértices informados.

## Exemplo de uso

```java
Graph graph = new Graph();

graph.addVertex(new Vertex("1"));
graph.addVertex(new Vertex("2"));
graph.addVertex(new Vertex("3"));

graph.addEdge("1", "2");
graph.addEdge("2", "3");

BreadthFirstSearch bfs = new BreadthFirstSearch();

Vertex origem = graph.getVerticeByLabel("1");
Vertex destino = graph.getVerticeByLabel("3");

bfs.executarBFS(graph, origem);
bfs.imprimirCaminho(destino);
```

Saída esperada:

```text
Menor caminho:
1 -> 2 -> 3
```

## Como executar

No terminal, dentro da pasta do projeto:

```bash
./gradlew run
```

Ou, no Windows:

```bash
gradlew.bat run
```

Caso o projeto não possua o plugin `application` configurado, execute a classe `Main.java` diretamente pela IDE.
