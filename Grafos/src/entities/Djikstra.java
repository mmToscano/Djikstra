package entities;

//https://github.com/franzejr/Dijkstra-Algorithm-Java-GUI/blob/master/src/Dijkstra.java


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Djikstra {

    // Lista que guarda os vertices pertencentes ao menor caminho encontrado
    List<Vertice> menorCaminho = new ArrayList<Vertice>();

    // Variavel que recebe os vertices pertencentes ao menor caminho
    Vertice verticeCaminho = new Vertice();

    // Variavel que guarda o vertice que esta sendo visitado
    Vertice atual = new Vertice();

    // Variavel que marca o vizinho do vertice atualmente visitado
    Vertice vizinho = new Vertice();

    // Lista dos vertices que ainda nao foram visitados
    List<Vertice> naoVisitados = new ArrayList<Vertice>();

    public List<Vertice> encontrarMenorCaminho(Grafo grafo, Vertice v1, Vertice v2){

        menorCaminho.add(v1);

        for(int count = 0; count < grafo.Vertices.size(); count++){

            //coloca o peso do vértice inicial para 0 e o resto para o valor máximo.
            if(grafo.Vertices.get(count).Rotulo == v1.Rotulo){
                grafo.Vertices.get(count).Peso = 0;
            }else{
                grafo.Vertices.get(count).Peso = 999;
            }

            naoVisitados.add(grafo.Vertices.get(count));
        }

        Collections.sort(naoVisitados);

        while(!this.naoVisitados.isEmpty()){

            atual = this.naoVisitados.get(0);
            //System.out.println("Pegou este vértice: " + atual);

            /*
             * Para cada vizinho (cada aresta), calcula-se a sua possivel
             * distancia, somando a distancia do vertice atual com a da aresta
             * correspondente. Se essa distancia for menor que a distancia do
             * vizinho, esta eh atualizada.
             */

            for(int count = 0; count < atual.Arestas.size(); count++){

                vizinho = atual.Arestas.get(count).Destino;
                //System.out.println("Olhando o vizinho de " + atual + ": " + vizinho);

                if(!vizinho.Visitado){

                    if(vizinho.Peso > (atual.Peso + atual.Arestas.get(count).Distancia)){

                        vizinho.Peso = atual.Peso + atual.Arestas.get(count).Distancia;
                        vizinho.Pai = atual;

                        if(vizinho == v2){
                            menorCaminho.clear();
                            verticeCaminho = vizinho;
                            menorCaminho.add(vizinho);
                            while(verticeCaminho.Pai != null){
                                menorCaminho.add(verticeCaminho.Pai);
                                verticeCaminho = verticeCaminho.Pai;
                            }
                            Collections.sort(menorCaminho);
                        }
                    }
                }
            }

            atual.visitar();
            this.naoVisitados.remove(atual);
            /*
             * Ordena a lista, para que o vertice com menor distancia fique na
             * primeira posicao
             */

            Collections.sort(naoVisitados);
            //System.out.println("Nao foram visitados ainda:"+naoVisitados);


        }

        //String resultado = "Menor caminho: " + menorCaminho;
        return menorCaminho;
    }


}
