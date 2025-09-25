package machine

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    var moneyAvailable = 550
    var waterAvailable = 400
    var milkAvailable = 540
    var coffeeBeansAvailable = 120
    var cupsAvailable = 9

    printCurrentState(waterAvailable, milkAvailable, coffeeBeansAvailable, cupsAvailable, moneyAvailable)

    println("Write action (buy, fill, take):")
    val action = scanner.nextLine()

    handleAction(action, scanner,
        waterAvailable, milkAvailable, coffeeBeansAvailable, cupsAvailable, moneyAvailable)

/*    println("Write how many ml of water the coffee machine has:")
    waterAvailable = scanner.nextInt()

    println("Write how many ml of milk the coffee machine has:")
    milkAvailable = scanner.nextInt()

    println("Write how many grams of coffee beans the coffee machine has:")
    coffeeBeansAvailable = scanner.nextInt()

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
    }*/

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

fun handleAction(
    action: String,
    scanner: Scanner,
    waterAvailable: Int,
    milkAvailable: Int,
    coffeeBeansAvailable: Int,
    cupsAvailable: Int,
    moneyAvailable: Int
) {
    when (action) {
        "buy" -> {
            println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
            val coffeeChoice = scanner.nextLine()

            when (coffeeChoice) {
                "1" -> makeCoffee(
                    250,
                    0,
                    16,
                    1,
                    4,
                    waterAvailable, milkAvailable, coffeeBeansAvailable, cupsAvailable, moneyAvailable)
                "2" -> makeCoffee(
                    350,
                    75,
                    20,
                    1,
                    7,
                    waterAvailable, milkAvailable, coffeeBeansAvailable, cupsAvailable, moneyAvailable)
                "3" -> makeCoffee(
                    200,
                    100,
                    12,
                    1,
                    6,
                    waterAvailable, milkAvailable, coffeeBeansAvailable, cupsAvailable, moneyAvailable)
            }
        }
        "fill" -> fillMachine(scanner, waterAvailable, milkAvailable, coffeeBeansAvailable, cupsAvailable, moneyAvailable)
        "take" -> takeMoney(waterAvailable, milkAvailable, coffeeBeansAvailable, cupsAvailable, moneyAvailable)
    }
}

fun printCurrentState(
    waterAvailable: Int,
    milkAvailable: Int,
    coffeeBeansAvailable: Int,
    cupsAvailable: Int,
    moneyAvailable: Int
) {
    println("The coffee machine has:")
    println("$waterAvailable ml of water")
    println("$milkAvailable ml of milk")
    println("$coffeeBeansAvailable g of coffee beans")
    println("$cupsAvailable disposable cups")
    println("$$moneyAvailable of money")
    println()
}

fun makeCoffee(
    waterNeeded: Int,
    milkNeeded: Int,
    coffeeBeansNeeded: Int,
    cupsNeeded: Int,
    moneyEarned: Int,
    waterAvailable: Int,
    milkAvailable: Int,
    coffeeBeansAvailable: Int,
    cupsAvailable: Int,
    moneyAvailable: Int
) {
    val newWaterAvailable = waterAvailable - waterNeeded
    val newMilkAvailable = milkAvailable - milkNeeded
    val newCoffeeBeansAvailable = coffeeBeansAvailable - coffeeBeansNeeded
    val newCupsAvailable = cupsAvailable - cupsNeeded
    val newMoneyAvailable = moneyAvailable + moneyEarned

    println()
    printCurrentState(newWaterAvailable, newMilkAvailable, newCoffeeBeansAvailable, newCupsAvailable, newMoneyAvailable)
}

fun fillMachine(
    scanner: Scanner,
    waterAvailable: Int,
    milkAvailable: Int,
    coffeeBeansAvailable: Int,
    cupsAvailable: Int,
    moneyAvailable: Int
) {
    println("Write how many ml of water you want to add:")
    val waterToAdd = scanner.nextInt()
    println("Write how many ml of milk you want to add:")
    val milkToAdd = scanner.nextInt()
    println("Write how many grams of coffee beans you want to add:")
    val coffeeBeansToAdd = scanner.nextInt()
    println("Write how many disposable cups you want to add:")
    val cupsToAdd = scanner.nextInt()

    val newWaterAvailable = waterAvailable + waterToAdd
    val newMilkAvailable = milkAvailable + milkToAdd
    val newCoffeeBeansAvailable = coffeeBeansAvailable + coffeeBeansToAdd
    val newCupsAvailable = cupsAvailable + cupsToAdd

    println()
    printCurrentState(newWaterAvailable, newMilkAvailable, newCoffeeBeansAvailable, newCupsAvailable, moneyAvailable)
}

fun takeMoney(
    waterAvailable: Int,
    milkAvailable: Int,
    coffeeBeansAvailable: Int,
    cupsAvailable: Int,
    moneyAvailable: Int
) {
    println("I gave you $$moneyAvailable")
    val newMoneyAvailable = 0
    println()
    printCurrentState(waterAvailable, milkAvailable, coffeeBeansAvailable, cupsAvailable, newMoneyAvailable)
}
