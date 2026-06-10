package entities;

public class Moto extends Veiculo implements Conectavel {

    private Boolean temSideCar;
    private String tipoCambio;

    public Moto() {
    }

    public Moto(Boolean temSideCar, String tipoCambio) {
        this.temSideCar = temSideCar;
        this.tipoCambio = tipoCambio;
    }

    public Moto(String marca, Integer ano, Double preco, Boolean temSideCar, String tipoCambio) {
        super(marca, ano, preco);
        this.temSideCar = temSideCar;
        this.tipoCambio = tipoCambio;
    }

    public void empinar() {
        System.out.println("Empinando");
    }

    public void trocarmarcha() {
        System.out.println("Trocando de marcha");
    }

    @Override
    public String toString() {
        return "Moto{" +
                "temSideCar=" + temSideCar +
                ", tipoCambio='" + tipoCambio + '\'' +
                '}';
    }

    @Override
    public void conectarBluetooth() {
        System.out.println("Bluetooth conectado");
    }

    @Override
    public void sincronizarDados() {
        System.out.println("Dados sincronizados");
    }
}
