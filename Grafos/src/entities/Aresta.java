package entities;

import java.util.Scanner;

public class Aresta {

    Scanner sc = new Scanner(System.in);

    public Vertice Origem;
    public Vertice Destino;
    public int Distancia;


    public Aresta(){

    }

    public Aresta(Vertice origem, Vertice destino, int distancia){
        Origem = origem;
        Destino = destino;
        Distancia = distancia;
    }

    public void add(Vertice origem, Vertice destino){
        Origem = origem;
        Destino = destino;
    }

    @Override
    public String toString() {
        return "{" +
                "Vértice Origem=" + Origem.Rotulo +
                " -> Vértice Destino=" + Destino.Rotulo +
                "| Distância = " + Distancia + "}";
    }
}
