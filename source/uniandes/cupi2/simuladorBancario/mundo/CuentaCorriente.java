/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_simuladorBancario
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.simuladorBancario.mundo;
import java.util.ArrayList;
/**
 * Clase que representa la cuenta corriente de un cliente.
 */
public class CuentaCorriente
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Saldo actual de la cuenta corriente.
     */
    private double saldo;
    private ArrayList<Transaccion> transacciones;
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa la cuenta corriente. <br>
     * <b>post: </b> Se inicializó el saldo en 0.
     */
    public CuentaCorriente( )
    {
        saldo = 0;
        transacciones = new ArrayList<>();
    }

    /**
     * Retorna el saldo de la cuenta del cliente. <br>
     * @return Saldo de la cuenta corriente.
     */
    public double darSaldo( )
    {
        return saldo;
    }

    /**
     * Consigna una cantidad al saldo sin registrar transacción.
     * Usado para consignaciones internas como el cierre del CDT.
     * @param pMonto Monto a consignar.
     */
    public void consignarMonto(double pMonto, int mes) 
    {
        saldo += pMonto;
        transacciones.add(new Transaccion("Consignación", pMonto, mes));
    }

    /**
     * Retira un monto de dinero de la cuenta del cliente. <br>
     * <b>post: </b> El saldo se redujo en el monto de dinero dado.
     * @param pMonto Monto de dinero a retirar en la cuenta. pMonto > 0.
     */
    public void retirarMonto(double pMonto, int mes)
    {
        saldo -= pMonto;
        transacciones.add(new Transaccion("Retiro", pMonto, mes));
    }
    
    public ArrayList<Transaccion> darTransaccionesMes(int mes) {
        ArrayList<Transaccion> resultado = new ArrayList<>();
        for (Transaccion t : transacciones) {
            if (t.darMes() == mes) {
                resultado.add(t);
            }
        }
        return resultado;
    }
}