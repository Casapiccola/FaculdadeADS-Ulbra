package entities;

public class Carro extends Veiculo {

    private Integer numPortas;
    private Boolean tetoSolar;

    public Carro() {
    }

    public Carro(Integer numPortas, Boolean tetoSolar) {
        this.numPortas = numPortas;
        this.tetoSolar = tetoSolar;
    }

    public Carro(String marca, Integer ano, Double preco, Integer numPortas, Boolean tetoSolar) {
        super(marca, ano, preco);
        this.numPortas = numPortas;
        this.tetoSolar = tetoSolar;
    }

    public Integer getNumPortas() {
        return numPortas;
    }

    public void setNumPortas(Integer numPortas) {
        this.numPortas = numPortas;
    }

    public Boolean getTetoSolar() {
        return tetoSolar;
    }

    public void setTetoSolar(Boolean tetoSolar) {
        this.tetoSolar = tetoSolar;
    }

    public void abrirPorta() {
        System.out.println("Porta abrindo");
    }

    public void ligarAr() {
        System.out.println("Ar ligando");
    }

    @Override
    public String toString() {
        return "Carro{" +
                "numPortas=" + numPortas +
                ", tetoSolar=" + tetoSolar +
                '}';
    }

}
