package io.github.luccasena.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Vertex {
    @EqualsAndHashCode.Include
    private String value;
    private List<Vertex> neighborhood;
    private int degree;

    public Vertex(String value) {
        this.value = value;
        this.neighborhood = new ArrayList<>();
    }

    public void addAdjacent(Vertex adjacent) {
        this.neighborhood.add(adjacent);
    }

}
