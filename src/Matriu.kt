import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    println("¿Cuántos alumnos hay en el aula?")
    val cantidadAlumnos = scanner.nextInt()
    scanner.nextLine()

    val alumnos = Array(cantidadAlumnos) { "" }

    for (i in alumnos.indices) {
        println("Introduce el nombre del alumno ${i + 1}:")
        alumnos[i] = scanner.nextLine()
    }

    val nombresConA = alumnos.count { it.startsWith("A", ignoreCase = true) }

    val nombresConS = alumnos.count { it.contains("s", ignoreCase = true) }

    println("Nombres que comienzan con 'A': $nombresConA")
    println("Nombres que contienen la letra 's': $nombresConS")

    println("Introduce una letra para buscar en los nombres de los alumnos:")
    val letraBuscar = scanner.nextLine()

    val aparicionesLetra = alumnos.sumOf { nombre ->
        nombre.count { it.equals(letraBuscar[0], ignoreCase = true) }
    }

    val nombresConLetra = alumnos.filter { it.contains(letraBuscar, ignoreCase = true) }

    println("La letra '$letraBuscar' aparece un total de $aparicionesLetra veces en los nombres.")
    println("Nombres que contienen la letra '$letraBuscar':")
    nombresConLetra.forEach { println(it) }
}
