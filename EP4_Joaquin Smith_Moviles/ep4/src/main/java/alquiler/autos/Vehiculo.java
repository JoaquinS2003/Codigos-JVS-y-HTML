package alquiler.autos;

public class Vehiculo {
    private String numeroPlaca;
    private String modelo;
    private String marca;

    public Vehiculo(String numeroPlaca, String modelo, String marca) {
        this.numeroPlaca = numeroPlaca;
        this.modelo = modelo;
        this.marca = marca;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void imprimirInfoVehiculo() {
        System.out.println("Número de la placa: " + numeroPlaca);
        System.out.println("Modelo del vehiculo: " + modelo);
        System.out.println("Marca: " + marca);
    }
}
