package alquiler.autos;

public class Main {
    public static void main(String[] args) {
        Auto auto = new Auto("ABC123", "Sedán", "Toyota", 4, 65.0);
        Camioneta camioneta = new Camioneta("XYZ456", "Pickup", "Ford", 1000.0, 80.0);

        Reserva reserva1 = new Reserva(auto, 8);
        Reserva reserva2 = new Reserva(camioneta, 9);

        System.out.println("Reserva 1:");
        reserva1.imprimirReserva();

        System.out.println("Reserva 2:");
        reserva2.imprimirReserva();
    }
}
