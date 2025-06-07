package uniandes.cupi2.simuladorBancario.mundo;

public class Transaccion {
    private String tipo; // Ej: "Consignación" o "Retiro"
    private double monto;
    private int mes;

    public Transaccion(String tipo, double monto, int mes) {
        this.tipo = tipo;
        this.monto = monto;
        this.mes = mes;
    }

    public int darMes() {
        return mes;
    }

    @Override
    public String toString() {
        return tipo + ": " + monto + " (Mes " + mes + ")";
    }
}
