package machine

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    println("Write how many ml of water the coffee machine has:")
    val waterAvailable = scanner.nextInt()

    println("Write how many ml of milk the coffee machine has:")
    val milkAvailable = scanner.nextInt()

    println("Write how many grams of coffee beans the coffee machine has:")
    val coffeeBeansAvailable = scanner.nextInt()

    println("Write how many cups of coffee you will need:")
    val cupsNeeded = scanner.nextInt()

    val possibleCupsFromWater = waterAvailable / 200
    val possibleCupsFromMilk = milkAvailable / 50
    val possibleCupsFromCoffeeBeans = coffeeBeansAvailable / 15

    val maxPossibleCups = minOf(possibleCupsFromWater, possibleCupsFromMilk, possibleCupsFromCoffeeBeans)

    when {
        maxPossibleCups == cupsNeeded -> println("Yes, I can make that amount of coffee")
        maxPossibleCups > cupsNeeded -> println("Yes, I can make that amount of coffee (and even ${maxPossibleCups - cupsNeeded} more than that)")
        else -> println("No, I can make only $maxPossibleCups cups of coffee")
    }

/*    println("For $input cups of coffee you will need:")
    println("${input * 200} ml of water")
    println("${input * 50} ml of milk")
    println("${input * 15} g of coffee beans")*/

/*    println("Starting to make a coffee")
    println("Grinding coffee beans")
    println("Boiling water")
    println("Mixing boiled water with crushed coffee beans")
    println("Pouring coffee into the cup")
    println("Pouring some milk into the cup")
    println("Coffee is ready!")*/
}
