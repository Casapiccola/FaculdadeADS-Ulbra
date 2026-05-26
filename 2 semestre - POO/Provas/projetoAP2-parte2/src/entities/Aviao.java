package entities;

public class Aviao {

    private String modelo;
    private Float tamanhoTanqueEmLitros;

    public Aviao() {}

    public Aviao(String modelo, Float tamanhoTanqueEmLitros) {
        this.modelo = modelo;
        this.tamanhoTanqueEmLitros = tamanhoTanqueEmLitros;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Float getTamanhoTanqueEmLitros() {
        return tamanhoTanqueEmLitros;
    }

    public void setTamanhoTanqueEmLitros(Float tamanhoTanqueEmLitros) {
        this.tamanhoTanqueEmLitros = tamanhoTanqueEmLitros;
    }

    @Override
    public String toString() {
        return "Aviao{" +
                "modelo='" + modelo + '\'' +
                ", tamanhoTanqueEmLitros=" + tamanhoTanqueEmLitros +
                '}';
    }
}
