package com.lucas.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DescuentosTest {

    private final Descuentos descuentos = new Descuentos();

    // Caso 1: 10% de descuento sobre 100
    @Test
    void precio100Con10DeDescuentoDevuelve90() {
        assertEquals(90, descuentos.calcularPrecioFinal(100, 10));
    }

    // Caso 2: 20% de descuento sobre 200
    @Test
    void precio200Con20DeDescuentoDevuelve160() {
        assertEquals(160, descuentos.calcularPrecioFinal(200, 20));
    }

    // Caso 3: 0% de descuento (sin descuento)
    @Test
    void precio50Con0DeDescuentoDevuelve50() {
        assertEquals(50, descuentos.calcularPrecioFinal(50, 0));
    }

    // Caso 4: 50% de descuento sobre 500
    @Test
    void precio500Con50DeDescuentoDevuelve250() {
        assertEquals(250, descuentos.calcularPrecioFinal(500, 50));
    }

    // Caso 5 (elegido): 100% de descuento -> precio final 0
    // Lo elegí porque es el límite superior del descuento: prueba el extremo de la fórmula.
    // Si la implementación restara mal (p. ej. precio * (descuento / 100) con enteros)
    // o manejara el 100% de forma incorrecta, el resultado no sería 0.
    @Test
    void precio250Con100DeDescuentoDevuelve0() {
        assertEquals(0, descuentos.calcularPrecioFinal(250, 100));
    }

    // Caso 6: 25% de descuento sobre un precio con centavos
    // Lo agregué porque el comercio usa precios con decimales (120.50 soles);
    // verifica que la fórmula calcula correctamente el resultado fraccionario (90.375).
    @Test
    void precio12050Con25DeDescuentoDevuelve90375() {
        assertEquals(90.375, descuentos.calcularPrecioFinal(120.50, 25), 0.001);
    }

    // Caso 7: 30% de descuento sobre un precio alto
    // Lo agregué para cubrir un descuento típico de ofertas sobre montos grandes:
    // confirma que el cálculo no pierde exactitud con valores altos (560).
    @Test
    void precio800Con30DeDescuentoDevuelve560() {
        assertEquals(560, descuentos.calcularPrecioFinal(800, 30));
    }
}