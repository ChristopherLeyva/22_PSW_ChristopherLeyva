# 22_PSW_ChristopherLeyva

## Laboratorio: Sistema de Calificaciones

Proyecto Maven con pruebas unitarias (JUnit 5) para la clase `com.lucas.testing.Calificaciones`.

Autor: Lucas

### Estructura

- `src/main/java/com/lucas/testing/Calificaciones.java` — clase probada.
  - `calcularPromedio(nota1, nota2, nota3)` → promedio aritmético.
  - `estaAprobado(promedio)` → `true` si el promedio es mayor o igual a 13 (nota de aprobación).
- `src/test/java/com/lucas/testing/CalificacionesTest.java` — pruebas unitarias (8 casos).

### Ejecución

```bash
mvn test
```

Salida esperada (verde):

```
Tests run: 8, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

### Casos de prueba y justificación

| # | Método | Entrada | Esperado | Justificación |
|---|--------|---------|----------|---------------|
| 1 | `calcularPromedio` | 15, 14, 16 | 15 | Caso base: promedio exacto de valores intermedios. |
| 2 | `estaAprobado` | 15 | `true` | Promedio claramente superior al límite: debe aprobar. |
| 3 | `calcularPromedio` | 10, 12, 14 | 12 | Promedio exacto con notas bajas. |
| 4 | `estaAprobado` | 13 | `true` | **Prueba de límite**: 13 es exactamente la nota mínima de aprobación (`>= 13`). |
| 5 | `calcularPromedio` | 20, 18, 16 | 18 | **Caso propuesto (5.º):** verifica el promedio con notas altas; si el divisor estuviera mal (p. ej. `/2`), 54/2=27 fallaría la prueba, detectando el defecto. |
| 6 | `estaAprobado` | 12 | `false` | Valor justo por debajo del límite: debe reprobar. |
| 7 | `estaAprobado` | 5 | `false` | Promedio muy bajo: debe reprobar. |
| 8 | `estaAprobado` | 12.99 | `false` | **Reto (octavo caso):** prueba de límite complementaria al caso 4. Confirma que cualquier valor inmediatamente inferior a 13 (aunque sea por milésimas) NO aprueba, garantizando que el umbral se controle con `>=` y no con `>` (que dejaría pasar 13). |

### Evidencia de prueba fallida (rojo)

Siguiendo el patrón de la clase, se introdujo un defecto intencional
(`calcularPromedio` dividía entre 2 en vez de 3). El runner detectó 3 fallos:

```
calcularPromedio15_14_16Devuelve15: expected: <15.0> but was: <22.5>
calcularPromedio10_12_14Devuelve12: expected: <12.0> but was: <18.0>
calcularPromedio20_18_16Devuelve18: expected: <18.0> but was: <27.0>
Tests run: 8, Failures: 3
BUILD FAILURE
```

La prueba fallida no estaba mal escrita: estaba alertando correctamente sobre el defecto en el código (principio: "las pruebas demuestran la presencia de defectos").

### Entregable

Para la evidencia en Google Drive: revisar el reporte generado por surefire en
`target/surefire-reports/` (incluye `com.lucas.testing.CalificacionesTest.txt`
y `target/surefire-reports/TEST-com.lucas.testing.CalificacionesTest.xml`)
y capturar pantalla de la salida verde de `mvn test`.