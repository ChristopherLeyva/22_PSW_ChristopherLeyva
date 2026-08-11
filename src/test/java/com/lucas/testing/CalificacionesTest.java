package com.lucas.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalificacionesTest {

    private final Calificaciones calificaciones = new Calificaciones();

    // Caso 1: Promedio de 15, 14 y 16 debe ser 15
    @Test
    void calcularPromedio15_14_16Devuelve15() {
        assertEquals(15, calificaciones.calcularPromedio(15, 14, 16));
    }

    // Caso 2: Promedio 15 debe estar aprobado
    @Test
    void estaAprobadoConPromedio15DevuelveTrue() {
        assertTrue(calificaciones.estaAprobado(15));
    }

    // Caso 3: Promedio de 10, 12 y 14 debe ser 12
    @Test
    void calcularPromedio10_12_14Devuelve12() {
        assertEquals(12, calificaciones.calcularPromedio(10, 12, 14));
    }

    // Caso 4: Promedio 13 es el límite de aprobación
    @Test
    void estaAprobadoConPromedio13DevuelveTrueEnElLimite() {
        assertTrue(calificaciones.estaAprobado(13));
    }

    // Caso 5: Promedio de 20, 18 y 16 debe ser 18
    @Test
    void calcularPromedio20_18_16Devuelve18() {
        assertEquals(18, calificaciones.calcularPromedio(20, 18, 16));
    }

    // Caso 6: Promedio 12 debe estar desaprobado
    @Test
    void estaAprobadoConPromedio12DevuelveFalse() {
        assertFalse(calificaciones.estaAprobado(12));
    }

    // Caso 7: Promedio 5 debe estar desaprobado
    @Test
    void estaAprobadoConPromedio05DevuelveFalse() {
        assertFalse(calificaciones.estaAprobado(5));
    }

    // RETO - Caso 8: Promedio 12.99 (justo debajo del límite) debe estar desaprobado
    @Test
    void estaAprobadoConPromedio1299DevuelveFalseJustoDebajoDelLimite() {
        assertFalse(calificaciones.estaAprobado(12.99));
    }
}