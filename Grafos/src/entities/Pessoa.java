package entities;

public class Pessoa {

    public String Nome;
    private int Idade;
    public Pessoa Pai;
    public Pessoa Mae;

    public Pessoa() {
        Nome = "";
        Idade = 0;
        Pai = null;
        Mae = null;
    }


    public void imprimir(){
        System.out.println(toString());
    }

    public int obterIdade(){
        return Idade;
    }

    public void obterAvo(){
        if(Pai == null){
            System.out.println("Sem avós por parte de pai");
        }else{
            System.out.println("Avô por parte de pai: " + Pai.Pai);
            System.out.println("Avó por parte de pai: " + Pai.Mae);
        }

        if(Mae == null){
            System.out.println("Sem avós por parte de mãe");
        }else{
            System.out.println("Avô por parte de mãe: " + Mae.Pai);
            System.out.println("Avó por parte de mãe: " + Mae.Mae);
        }
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int idade) {
        Idade = idade;
    }

    public Pessoa getPai() {
        return Pai;
    }

    public void setPai(Pessoa pai) {
        Pai = pai;
    }

    public Pessoa getMae() {
        return Mae;
    }

    public void setMae(Pessoa mae) {
        Mae = mae;
    }

    @Override
    public String toString() {
        return "entities.Pessoa{" +
                "Nome='" + Nome + '\'' +
                ", Idade=" + Idade +
                ", Pai=" + Pai +
                ", Mae=" + Mae +
                '}';
    }
}
