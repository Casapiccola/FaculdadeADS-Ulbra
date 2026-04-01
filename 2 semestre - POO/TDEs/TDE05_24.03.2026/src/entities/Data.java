package entities;

import java.time.DateTimeException;

public class Data {

    private int dia;
    private int mes;
    private int ano;

    public Data() {}

    public Data(int dia, int mes, int ano) {
        if (mes == 2 && dia > 28 || mes > 12) {
            throw new DateTimeException("Data inválida!");
        }
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return getDia()
                + "/"
                + getMes()
                + "/"
                + getAno();
    }
}
