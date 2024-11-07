import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    println("Introduce un texto:")
    val texto = scanner.nextLine()

    println("Introduce la palabra que quieres buscar en el texto:")
    val palabraBuscar = scanner.nextLine()

    val palabras = texto.split("\\s+".toRegex())
    var contador = 0

    for (palabra in palabras) {
        if (palabra.equals(palabraBuscar, ignoreCase = true)) {
            contador++
        }
    }
    println("La palabra \"$palabraBuscar\" aparece $contador veces en el texto.")
}
