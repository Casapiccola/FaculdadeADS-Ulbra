package entities;

public class Genero {

    private String descricao;
    private String tag;

    public Genero() {
    }

    public Genero(String descricao, String tag) {
        this.descricao = descricao;
        this.tag = tag;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "descricao='" + descricao + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
