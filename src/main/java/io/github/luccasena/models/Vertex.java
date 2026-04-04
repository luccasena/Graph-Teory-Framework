package io.github.luccasena.models;

public class Vertex {
    private String value;
    private int degree;

    public Vertex(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }
}
