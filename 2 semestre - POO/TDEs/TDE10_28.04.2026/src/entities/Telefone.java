package entities;

public class Telefone {

    private Integer codArea;
    private String numero;
    private String descricao;

    public Telefone() {}

    public Telefone(Integer codArea, String numero, String descricao) {
        this.codArea = codArea;
        this.numero = numero;
        this.descricao = descricao;
    }

    public Integer getCodArea() {
        return codArea;
    }

    public void setCodArea(Integer codArea) {
        this.codArea = codArea;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "codArea='" + codArea + '\'' +
                ", numero='" + numero + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
