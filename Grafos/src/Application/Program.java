package Application;

import entities.Djikstra;
import entities.Grafo;


public class Program {

    public static void main(String[] args) {


        Grafo g = new Grafo();
        Djikstra dj = new Djikstra();

        g.addVertice('a');
        g.addVertice('b');
        g.addVertice('c');
        g.addVertice('d');
        g.addVertice('e');

        g.addAresta('a', 'b', 5);
        g.addAresta('a', 'c', 1);
        g.addAresta('b', 'c', 4);
        g.addAresta('c', 'b', 2);
        g.addAresta('c', 'd', 5);
        g.addAresta('c', 'e', 5);
        g.addAresta('b', 'd', 2);
        g.addAresta('b', '3', 4);
        g.addAresta('d', 'e', 2);

        System.out.println(dj.encontrarMenorCaminho(g, g.buscarVertice('a'), g.buscarVertice('e')));

        //System.out.println(g.existeCaminho('a', 'h'));

    }
}
