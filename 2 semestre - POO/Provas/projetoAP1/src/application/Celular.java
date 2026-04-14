package application;

public class Celular {

    private String marca;
    private String modelo;
    private Bateria bateria;

    public Celular() {
    }

    public Celular(String marca, String modelo, Bateria bateria) {
        this.marca = marca;
        this.modelo = modelo;
        this.bateria = bateria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Bateria getBateria() {
        return bateria;
    }

    public void setBateria(Bateria bateria) {
        this.bateria = bateria;
    }

    @Override
    public String toString() {
        return "Celular{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", bateria=" + bateria.toString() +
                '}';
    }

    public void usarCelular(int consumo) {
        this.bateria.gastarBateria(consumo);
    }

    public void carregarCelular() {
        this.bateria.carregarBateria();
        System.out.println("Carga completa!");
    }

}
