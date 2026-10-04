# pgrAvanzado — Gestión avanzada de trabajadores

## 1. Objetivo

Desarrollar una aplicación de consola para gestionar una colección de trabajadores utilizando las funcionalidades avanzadas de `List` y programación funcional de Java.

El objetivo del proyecto es practicar:

* `List`
* `ArrayList`
* Lambdas
* `Predicate`
* `Consumer`
* `Function`
* `UnaryOperator`
* `Comparator`
* `Comparator.comparing()`
* `thenComparing()`
* `reversed()`
* `forEach()`
* `removeIf()`
* `replaceAll()`
* `sort()`
* Method References
* Reutilización de comportamientos
* Separación entre datos y comportamiento

> **Importante:** todavía NO se permite utilizar Streams.
> No utilizar `stream()`, `filter()`, `map()`, `flatMap()`, `collect()` ni `reduce()`.

---

# 2. Modelo

Crear una clase:

```java
Trabajador
```

con los siguientes atributos:

```text
id
nombre
edad
salario
departamento
```

La colección principal será:

```java
List<Trabajador> trabajadores;
```

---

# 3. Datos iniciales

El programa deberá comenzar con al menos los siguientes trabajadores:

| ID | Nombre | Edad | Salario | Departamento   |
| -: | ------ | ---: | ------: | -------------- |
|  1 | Joel   |   20 |    1800 | Desarrollo     |
|  2 | Ana    |   25 |    2200 | Diseño         |
|  3 | Carlos |   17 |    1500 | Desarrollo     |
|  4 | Pedro  |   30 |    2800 | Administración |
|  5 | Lucía  |   22 |    2100 | Diseño         |
|  6 | Miguel |   30 |    2500 | Desarrollo     |
|  7 | Laura  |   27 |    1900 | Administración |

Puedes añadir más trabajadores si lo consideras necesario para probar correctamente las funcionalidades.

---

# 4. Menú principal

El programa deberá mostrar:

```text
========================================
       GESTIÓN DE TRABAJADORES
========================================

1. Mostrar trabajadores
2. Buscar trabajadores
3. Eliminar trabajadores
4. Modificar trabajadores
5. Ordenar trabajadores
6. Estadísticas
7. Aplicar modificaciones masivas
8. Procesar trabajadores
9. Restaurar trabajadores
0. Salir

Seleccione una opción:
```

---

# 5. Opción 1 — Mostrar trabajadores

Crear el siguiente submenú:

```text
========================================
       MOSTRAR TRABAJADORES
========================================

1. Mostrar todos
2. Mostrar nombres
3. Mostrar mayores de edad
4. Mostrar por departamento
5. Mostrar salarios
6. Volver
```

## 5.1 Mostrar todos

Mostrar todos los trabajadores.

Debe utilizarse:

```java
forEach()
```

No utilizar un `for` tradicional.

---

## 5.2 Mostrar nombres

Mostrar únicamente los nombres:

```text
Joel
Ana
Carlos
Pedro
Lucía
Miguel
Laura
```

Debe utilizarse un:

```java
Consumer<Trabajador>
```

---

## 5.3 Mostrar mayores de edad

Mostrar únicamente trabajadores con edad igual o superior a 18 años.

La condición debe representarse mediante:

```java
Predicate<Trabajador>
```

---

## 5.4 Mostrar por departamento

Solicitar al usuario un departamento.

Ejemplo:

```text
Introduzca departamento: Desarrollo
```

Mostrar únicamente los trabajadores pertenecientes a dicho departamento.

La condición debe poder reutilizarse.

---

## 5.5 Mostrar salarios

Mostrar únicamente el nombre y salario:

```text
Joel -> 1800 €
Ana -> 2200 €
...
```

Utilizar un comportamiento basado en:

```java
Consumer<Trabajador>
```

---

# 6. Opción 2 — Buscar trabajadores

Crear:

```text
========================================
       BUSCAR TRABAJADORES
========================================

1. Buscar por ID
2. Buscar por nombre
3. Buscar por departamento
4. Buscar mayores de una edad
5. Buscar salario superior a una cantidad
6. Buscar por rango de edad
7. Volver
```

---

## 6.1 Buscar por ID

Solicitar un ID y localizar el trabajador correspondiente.

---

## 6.2 Buscar por nombre

Solicitar un nombre y localizar los trabajadores que coincidan.

---

## 6.3 Buscar por departamento

Solicitar un departamento y localizar los trabajadores correspondientes.

---

## 6.4 Buscar mayores de una edad

Solicitar una edad:

```text
Edad: 25
```

Mostrar todos los trabajadores cuya edad sea igual o superior.

---

## 6.5 Buscar salario superior

Solicitar un salario:

```text
Salario: 2000
```

Mostrar trabajadores cuyo salario sea superior a esa cantidad.

---

## 6.6 Buscar por rango de edad

Solicitar:

```text
Edad mínima:
Edad máxima:
```

Mostrar trabajadores cuya edad esté dentro del rango.

---

## Requisito de diseño

Las condiciones de búsqueda deberán utilizar:

```java
Predicate<Trabajador>
```

Evitar crear un método independiente para cada posible condición.

---

# 7. Opción 3 — Eliminar trabajadores

Crear:

```text
========================================
       ELIMINAR TRABAJADORES
========================================

1. Eliminar por ID
2. Eliminar menores de edad
3. Eliminar por departamento
4. Eliminar salario inferior
5. Eliminar según condición
6. Volver
```

---

## 7.1 Eliminar por ID

Solicitar un ID y eliminar el trabajador correspondiente.

---

## 7.2 Eliminar menores de edad

Eliminar todos los trabajadores menores de 18 años.

Debe utilizarse:

```java
removeIf()
```

---

## 7.3 Eliminar por departamento

Solicitar un departamento y eliminar todos sus trabajadores.

---

## 7.4 Eliminar salario inferior

Solicitar un salario mínimo y eliminar todos los trabajadores cuyo salario sea inferior.

---

## 7.5 Eliminar según condición

Mostrar:

```text
¿Qué trabajadores desea eliminar?

1. Menores de edad
2. Salario inferior a 1800
3. Departamento Desarrollo
4. Nombre determinado
```

Cada opción deberá generar una condición diferente:

```java
Predicate<Trabajador>
```

y posteriormente utilizarse con:

```java
removeIf()
```

---

# 8. Opción 4 — Modificar trabajadores

Crear:

```text
========================================
       MODIFICAR TRABAJADORES
========================================

1. Modificar un trabajador
2. Aumentar salario
3. Aumentar edad
4. Cambiar departamento
5. Modificar según condición
6. Volver
```

---

## 8.1 Modificar un trabajador

Solicitar el ID del trabajador y permitir modificar sus datos.

---

## 8.2 Aumentar salario

Solicitar una cantidad:

```text
Cantidad: 200
```

Aumentar el salario de todos los trabajadores.

Debe utilizarse:

```java
replaceAll()
```

---

## 8.3 Aumentar edad

Incrementar la edad de todos los trabajadores en una cantidad indicada por el usuario.

---

## 8.4 Cambiar departamento

Solicitar:

```text
Departamento actual:
Nuevo departamento:
```

Modificar los trabajadores pertenecientes al departamento indicado.

---

## 8.5 Modificar según condición

Primero solicitar una condición:

```text
1. Mayores de 25
2. Departamento Desarrollo
3. Salario inferior a 2000
```

Después solicitar la modificación:

```text
1. Aumentar salario
2. Aumentar edad
3. Cambiar departamento
```

La solución deberá separar:

```text
Condición
    ↓
Predicate<Trabajador>

Modificación
    ↓
UnaryOperator<Trabajador>
```

---

# 9. Opción 5 — Ordenar trabajadores

Crear:

```text
========================================
       ORDENAR TRABAJADORES
========================================

1. Ordenar por nombre
2. Ordenar por edad
3. Ordenar por salario
4. Ordenar por departamento
5. Ordenar por varios criterios
6. Orden inverso
7. Volver
```

---

## 9.1 Ordenar por nombre

Utilizar:

```java
Comparator.comparing()
```

y una Method Reference cuando sea posible.

---

## 9.2 Ordenar por edad

Orden ascendente.

---

## 9.3 Ordenar por salario

Orden ascendente.

---

## 9.4 Ordenar por departamento

Orden alfabético por departamento.

---

## 9.5 Ordenar por varios criterios

Permitir seleccionar un primer criterio:

```text
1. Nombre
2. Edad
3. Salario
4. Departamento
```

Después seleccionar un segundo criterio.

Por ejemplo:

```text
Primer criterio: Edad
Segundo criterio: Nombre
```

La ordenación deberá utilizar:

```java
thenComparing()
```

---

## 9.6 Orden inverso

Permitir invertir el criterio seleccionado.

Utilizar:

```java
reversed()
```

---

# 10. Opción 6 — Estadísticas

Crear:

```text
========================================
       ESTADÍSTICAS
========================================

1. Número de trabajadores
2. Trabajador más joven
3. Trabajador más mayor
4. Mayor salario
5. Menor salario
6. Salario medio
7. Edad media
8. Volver
```

---

## 10.1 Número de trabajadores

Mostrar el número actual de trabajadores.

---

## 10.2 Trabajador más joven

Obtener el trabajador con menor edad.

---

## 10.3 Trabajador más mayor

Obtener el trabajador con mayor edad.

---

## 10.4 Mayor salario

Obtener el trabajador con mayor salario.

---

## 10.5 Menor salario

Obtener el trabajador con menor salario.

---

## 10.6 Salario medio

Calcular el salario medio de todos los trabajadores.

---

## 10.7 Edad media

Calcular la edad media.

---

## Restricción

Resolver inicialmente estas estadísticas sin utilizar Streams.

Se recomienda investigar y utilizar:

```java
Comparator
Function
```

cuando sean apropiados.

---

# 11. Opción 7 — Modificaciones masivas

Crear:

```text
========================================
       MODIFICACIONES MASIVAS
========================================

1. Aumentar todos los salarios
2. Reducir todos los salarios
3. Aumentar todas las edades
4. Aplicar porcentaje al salario
5. Modificación personalizada
6. Volver
```

---

## 11.1 Aumentar salarios

Solicitar una cantidad y aumentarla en todos los trabajadores.

---

## 11.2 Reducir salarios

Solicitar una cantidad y reducirla en todos los trabajadores.

---

## 11.3 Aumentar edades

Solicitar una cantidad y aumentarla en todos los trabajadores.

---

## 11.4 Aplicar porcentaje

Solicitar un porcentaje.

Ejemplo:

```text
Porcentaje: 10
```

Un trabajador con:

```text
1800 €
```

pasará a:

```text
1980 €
```

---

## 11.5 Modificación personalizada

Mostrar:

```text
1. Multiplicar salario
2. Sumar cantidad al salario
3. Restar cantidad al salario
```

Cada opción deberá generar un comportamiento diferente.

Utilizar:

```java
UnaryOperator<Trabajador>
```

---

# 12. Opción 8 — Procesar trabajadores

Crear:

```text
========================================
       PROCESAR TRABAJADORES
========================================

1. Obtener nombres
2. Obtener salarios
3. Obtener edades
4. Obtener departamentos
5. Transformar trabajadores
6. Volver
```

---

## 12.1 Obtener nombres

Transformar:

```text
List<Trabajador>
```

en:

```text
List<String>
```

utilizando:

```java
Function<Trabajador, String>
```

---

## 12.2 Obtener salarios

Transformar:

```text
List<Trabajador>
```

en:

```text
List<Double>
```

utilizando una `Function`.

---

## 12.3 Obtener edades

Transformar:

```text
List<Trabajador>
```

en:

```text
List<Integer>
```

---

## 12.4 Obtener departamentos

Transformar:

```text
List<Trabajador>
```

en:

```text
List<String>
```

---

## 12.5 Transformación personalizada

Crear un mecanismo que permita utilizar diferentes:

```java
Function<Trabajador, R>
```

para obtener diferentes propiedades del trabajador.

---

# 13. Procesamiento genérico

Crear un método que reciba:

```java
List<Trabajador>
Predicate<Trabajador>
Consumer<Trabajador>
```

El método deberá:

1. Recorrer los trabajadores.
2. Aplicar el `Predicate`.
3. Si devuelve `true`, ejecutar el `Consumer`.

Conceptualmente:

```text
List<Trabajador>
       |
       v
Predicate<Trabajador>
       |
       v
 ¿Cumple?
   /   \
 NO     SÍ
 |       |
 |       v
 |    Consumer
 |       |
 v       v
ignorar acción
```

El mismo método deberá poder utilizarse para:

* Mostrar mayores de edad.
* Mostrar trabajadores de Desarrollo.
* Mostrar salarios superiores a una cantidad.
* Mostrar únicamente nombres.
* Mostrar trabajadores que cumplan varias condiciones.

No crear un método específico para cada caso.

---

# 14. Restaurar trabajadores

El programa deberá conservar los datos iniciales.

Durante la ejecución los datos podrán cambiar debido a:

* eliminaciones
* modificaciones
* cambios de salario
* cambios de edad
* cambios de departamento

La opción:

```text
9. Restaurar trabajadores
```

deberá recuperar el estado inicial.

No se debe reiniciar el programa.

La restauración debe realizarse mediante una copia independiente de los datos iniciales.

---

# 15. Method References

A lo largo del proyecto deberán utilizarse Method References cuando sea posible.

Ejemplo:

```java
Persona::getEdad
```

en lugar de:

```java
p -> p.getEdad()
```

Debes identificar cuándo una lambda puede sustituirse por una Method Reference y cuándo no.

---

# 16. Requisitos de programación funcional

El proyecto debe utilizar obligatoriamente:

### `Predicate`

Para representar condiciones:

```java
Predicate<Trabajador>
```

---

### `Consumer`

Para representar acciones:

```java
Consumer<Trabajador>
```

---

### `Function`

Para transformar datos:

```java
Function<Trabajador, R>
```

---

### `UnaryOperator`

Para modificar elementos:

```java
UnaryOperator<Trabajador>
```

---

### `Comparator`

Para definir criterios de ordenación:

```java
Comparator<Trabajador>
```

---

# 17. Operaciones de `List` obligatorias

A lo largo del proyecto deben utilizarse:

```java
forEach()
removeIf()
replaceAll()
sort()
```

También deberán aparecer cuando sean necesarios:

```java
contains()
indexOf()
lastIndexOf()
subList()
```

---

# 18. Restricciones

## No utilizar

Todavía NO se permite utilizar:

```java
stream()
filter()
map()
flatMap()
collect()
reduce()
```

Tampoco se permite solucionar todo mediante bucles tradicionales cuando exista una operación de `List` apropiada para el objetivo.

---

# 19. Restricción de diseño

Evitar crear métodos específicos para cada combinación de operaciones.

No se busca terminar con:

```java
buscarMayores();

buscarMenores();

buscarDesarrollo();

buscarDiseño();

buscarSalarioAlto();

mostrarNombres();

mostrarSalarios();

mostrarMayores();

ordenarPorEdad();

ordenarPorSalario();
```

El objetivo es separar:

```text
DATOS
    ↓
List<Trabajador>

CONDICIÓN
    ↓
Predicate

TRANSFORMACIÓN
    ↓
Function

MODIFICACIÓN
    ↓
UnaryOperator

ORDENACIÓN
    ↓
Comparator

ACCIÓN
    ↓
Consumer
```

---

# 20. Reto final

El programa deberá ser capaz de realizar operaciones complejas combinando los comportamientos anteriores.

Por ejemplo:

> Mostrar trabajadores del departamento `Desarrollo`, mayores de 20 años y ordenados por salario descendente.

No se debe crear un método específico llamado:

```java
mostrarDesarrolloMayoresOrdenados();
```

La solución debe combinar:

```text
List<Trabajador>
        ↓
Predicate
        ↓
condición
        ↓
Comparator
        ↓
ordenación
        ↓
Consumer
        ↓
resultado
```

---

# 21. Reto adicional

Crear una operación que permita seleccionar dinámicamente:

```text
CONDICIÓN
```

y:

```text
ORDENACIÓN
```

Por ejemplo:

```text
Condición:

1. Mayores de edad
2. Desarrollo
3. Salario > 2000
4. Edad entre 20 y 30


Ordenación:

1. Nombre
2. Edad
3. Salario
4. Departamento
```

El programa deberá construir el comportamiento necesario y aplicarlo a la misma `List<Trabajador>`.

No crear un método diferente para cada combinación.

---

# 22. Objetivo final del bloque `List`

Al terminar este proyecto deberías ser capaz de identificar rápidamente:

```text
¿Necesito comprobar una condición?
        ↓
    Predicate


¿Necesito ejecutar una acción?
        ↓
    Consumer


¿Necesito transformar un objeto?
        ↓
    Function


¿Necesito modificar un objeto?
        ↓
    UnaryOperator


¿Necesito ordenar?
        ↓
    Comparator


¿Necesito ejecutar algo sobre todos?
        ↓
    forEach()


¿Necesito eliminar según una condición?
        ↓
    removeIf()


¿Necesito modificar todos?
        ↓
    replaceAll()


¿Necesito ordenar?
        ↓
    sort()
```

---

# 23. Siguiente bloque

Una vez terminado este proyecto se podrá pasar al bloque:

## `Set` avanzado

Contenidos:

* `HashSet`
* `LinkedHashSet`
* `TreeSet`
* `equals()`
* `hashCode()`
* Hashing
* Unicidad de objetos
* Orden natural
* `Comparable`
* `Comparator` con `TreeSet`
* Unión de conjuntos
* Intersección
* Diferencia
* `Set` de objetos
* Lambdas con `Set`
* Combinación `List` + `Set`
* Problemas reales de diseño con colecciones
