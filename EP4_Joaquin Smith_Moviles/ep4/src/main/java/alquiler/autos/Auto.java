package alquiler.autos;

public class Auto extends Vehiculo implements Alquilable {
    private int numerdodePuertas;
    private double costoDiario;

    public Auto(String numerodePlaca, String modeloVehiculo, String marcadelVehiculo, int numerdodePuertas, double costoDiario) {
        super(numerodePlaca, modeloVehiculo, marcadelVehiculo);
        this.numerdodePuertas = numerdodePuertas;
        this.costoDiario = costoDiario;
    }

    public int getCantidadPuertas() {
        return numerdodePuertas;
    }

    public void setCantidadPuertas(int numerdodePuertas) {
        this.numerdodePuertas = numerdodePuertas;
    }

    public double getTarifaDiaria() {
        return costoDiario;
    }

    public void setTarifaDiaria(double costoDiario) {
        this.costoDiario = costoDiario;
    }

    @Override
    public double calcularMontoAlquiler(int dias) {
        return costoDiario * dias;
    }

    @Override
    public void imprimirInfoVehiculo() {
        super.imprimirInfoVehiculo();
        System.out.println("Numero de puertas: " + numerdodePuertas);
        System.out.println("Tarifa diaria: " + costoDiario);
    }
}
