package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vertice implements Comparable<Vertice>{

    Scanner sc = new Scanner(System.in);

    public char Rotulo;
    public List<Aresta> Arestas;
    public int Peso;
    public boolean Visitado = false;
    public Vertice Pai;

    public static List<Vertice> VerticesDoCaminho = new ArrayList<>();


    public Vertice(){
        Rotulo = 0;
        Arestas = new ArrayList<>();
    }

    public Vertice (char v){
        Rotulo = v;
        Arestas = new ArrayList<>();
    }

    public void addAresta(Aresta a){
        Arestas.add(a);
    }

    public void addAresta(Vertice destino, int distancia){
        Arestas.add(new Aresta(this, destino, distancia));
        //new Aresta(this, destino);
    }


    public List<Aresta> imprimirArestas(){
        return Arestas;
    }

    @Override
    public String toString() {
        return "Rotulo=" + Rotulo;
                //" --- Arestas=" + Arestas;
    }

    public boolean EhAdjacente(Vertice destino){

        boolean retorno = false;

        for(Aresta item: Arestas){
            if(item.Destino.Rotulo == destino.Rotulo){
                retorno = true;
            }
        }

        return retorno;
    }

    public boolean existeCaminho(Vertice destino){

        boolean retorno = false;

            if(this.EhAdjacente(destino)){
                retorno = true;
            }else{
                for (Aresta item : Arestas) {
                   if(item.Destino.existeCaminho(destino)){
                       retorno = true;
                       break;
                }
            }
        }

        if(retorno == true){
            VerticesDoCaminho.add(this);
        }else{
            VerticesDoCaminho.removeAll(VerticesDoCaminho);
        }
        return retorno;

    }

    public int compareTo(Vertice vertice) {
        if(this.Peso < vertice.Peso) return -1;
        else if(this.Peso == vertice.Peso) return 0;

        return 1;

    }

    public void visitar(){
        this.Visitado = true;
    }


}
