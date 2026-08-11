package com.lucas.testing;

public class Descuentos {

    public double calcularPrecioFinal(double precio, double descuento) {
        return precio - (precio * descuento / 100);
    }
}