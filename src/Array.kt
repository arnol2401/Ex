import java.util.Scanner
import kotlin.random.Random

fun main() {
    val factos = Scanner(System.`in`)

    val frecuencias = IntArray(1000) { Random.nextInt(60, 201) }

    var frecuenciaMinima: Int
    var frecuenciaMaxima: Int
    var input: Boolean

    do {
        println("Introduce la frecuencia mínima (entre 60 y 200):")
        frecuenciaMinima = factos.nextInt()

        println("Introduce la frecuencia máxima (entre 60 y 200):")
        frecuenciaMaxima = factos.nextInt()

        input = frecuenciaMinima in 60..200 && frecuenciaMaxima in 60..200 && frecuenciaMinima < frecuenciaMaxima

        if (!input) {
            println("Error: Los valores introducidos no son correctos. Asegúrate de que:")
            println("- Las frecuencias están entre 60 y 200.")
            println("- La frecuencia mínima es menor que la frecuencia máxima.")
        }
    } while (!input)

    var dentroDelRango = 0
    var porDebajoDelRango = 0
    var porEncimaDelRango = 0

    for (frecuencia in frecuencias) {
        when {
            frecuencia < frecuenciaMinima -> porDebajoDelRango++
            frecuencia > frecuenciaMaxima -> porEncimaDelRango++
            else -> dentroDelRango++
        }
    }

    val totalRegistros = frecuencias.size
    val porcentajeDentro = dentroDelRango * 100.0 / totalRegistros
    val porcentajePorDebajo = porDebajoDelRango * 100.0 / totalRegistros
    val porcentajePorEncima = porEncimaDelRango * 100.0 / totalRegistros

    println("Resultados:")
    println("Frecuencia dentro del rango ($frecuenciaMinima - $frecuenciaMaxima): $dentroDelRango veces (${String.format("%.2f", porcentajeDentro)}%)")
    println("Frecuencia por debajo del rango (< $frecuenciaMinima): $porDebajoDelRango veces (${String.format("%.2f", porcentajePorDebajo)}%)")
    println("Frecuencia por encima del rango (> $frecuenciaMaxima): $porEncimaDelRango veces (${String.format("%.2f", porcentajePorEncima)}%)")
}
