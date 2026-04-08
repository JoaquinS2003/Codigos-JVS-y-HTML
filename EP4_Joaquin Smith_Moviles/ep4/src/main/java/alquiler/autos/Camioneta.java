package alquiler.autos;

public class Camioneta extends Vehiculo implements Alquilable {
    private double capacidadCarga;
    private double costoDiario;

    public Camioneta(String numeroPlaca, String modelo, String marcadeCamioneta, double capacidaddeCarga, double costoDiario) {
        super(numeroPlaca, modelo, marcadeCamioneta);
        this.capacidadCarga = capacidaddeCarga;
        this.costoDiario = costoDiario;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public double getTarifaDiaria() {
        return costoDiario;
    }

    public void setTarifaDiaria(double tarifaDiaria) {
        this.costoDiario = tarifaDiaria;
    }

    @Override
    public double calcularMontoAlquiler(int dias) {
        return costoDiario * dias;
    }

    @Override
    public void imprimirInfoVehiculo() {
        super.imprimirInfoVehiculo();
        System.out.println("Capacidad de carga: " + capacidadCarga);
        System.out.println("Tarifa diaria: " + costoDiario);
    }
}
