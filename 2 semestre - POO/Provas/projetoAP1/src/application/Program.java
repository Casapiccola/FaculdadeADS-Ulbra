import application.Bateria;
import application.Celular;

void main() {

    Bateria bateria = new Bateria(60, 4000);
    Celular celular = new Celular("Xiaomi", "Japones", bateria);

    celular.carregarCelular();
    celular.usarCelular(100);

    celular.carregarCelular();
    celular.usarCelular(20);

    celular.usarCelular(-10);

    celular.usarCelular(90);

    System.out.println(celular);
}