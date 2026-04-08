package alquiler.autos;

public class Reserva {
    private Alquilable vehiculo;
    private int cantidadDias;

    public Reserva(Alquilable vehiculo, int cantidadDias) {
        this.vehiculo = vehiculo;
        this.cantidadDias = cantidadDias;
    }

    public Alquilable getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Alquilable vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(int cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public double calcularMontoTotalAlquiler() {
        return vehiculo.calcularMontoAlquiler(cantidadDias);
    }

    public void imprimirReserva() {
        if (vehiculo instanceof Vehiculo) {
            ((Vehiculo) vehiculo).imprimirInfoVehiculo();
        }
        System.out.println("Numero de dias: " + cantidadDias);
        System.out.println("coste total: " + calcularMontoTotalAlquiler());
        System.out.println();
    }
}

