package machine

import java.util.Scanner

fun main() {
    println("Write how many cups of coffee you will need:")
    val scanner = Scanner(System.`in`)
    val input = scanner.nextInt()

    println("For $input cups of coffee you will need:")
    println("${input * 200} ml of water")
    println("${input * 50} ml of milk")
    println("${input * 15} g of coffee beans")

/*    println("Starting to make a coffee")
    println("Grinding coffee beans")
    println("Boiling water")
    println("Mixing boiled water with crushed coffee beans")
    println("Pouring coffee into the cup")
    println("Pouring some milk into the cup")
    println("Coffee is ready!")*/
}
