package entities;

public class Veiculo implements Manutivel {

    private String marca;
    private Integer ano;
    private Double preco;

    public Veiculo() {
    }

    public Veiculo(String marca, Integer ano, Double preco) {
        this.marca = marca;
        this.ano = ano;
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void acelerar() {
        System.out.println("VROOOOM... NHOOOM!");
    }

    public void frear() {
        System.out.println("iiiiiiinNHHHHH!");
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "marca='" + marca + '\'' +
                ", ano=" + ano +
                ", preco=" + preco +
                '}';
    }

    @Override
    public void realizarManutencao() {
        System.out.println("Manutencao realizada");
    }

    @Override
    public void verificarStatus() {
        System.out.println("Status veficado | Não existe status");
    }


}
