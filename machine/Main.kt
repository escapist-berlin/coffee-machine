package machine

import java.util.Scanner

data class MachineState(
    var water: Int = 400,
    var milk: Int = 540,
    var beans: Int = 120,
    var cups: Int = 9,
    var money: Int = 550
)

fun main() {
    val scanner = Scanner(System.`in`)
    val state = MachineState()

    while (true) {
        println("Write action (buy, fill, take, remaining, exit): ")
        val action = scanner.nextLine()
        println()

        when (action) {
            "buy" -> buy(scanner, state)
            "fill" -> fill(scanner, state)
            "take" -> take(state)
            "remaining" -> printState(state)
            "exit" -> return
        }
    }
}

fun buy(scanner: Scanner, state: MachineState) {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
    val choice = scanner.nextLine()

    when (choice) {
        "1" -> brew(state, 250, 0, 16, 4)
        "2" -> brew(state, 350, 75, 20, 7)
        "3" -> brew(state, 200, 100, 12, 6)
        "back" -> {
            println()
            return
        }
    }
}

fun brew(state: MachineState, water: Int, milk: Int, beans: Int, price: Int) {
    when {
        state.water < water -> {
            println("Sorry, not enough water!")
            println()
            return
        }
        state.milk < milk -> {
            println("Sorry, not enough milk!")
            println()
            return
        }
        state.beans < beans -> {
            println("Sorry, not enough beans!")
            println()
            return
        }
        state.cups < 1 -> {
            println("Sorry, not enough cups!")
            println()
            return
        }
    }

    println("I have enough resources, making you a coffee!")
    println()
    state.water -= water
    state.milk -= milk
    state.beans -= beans
    state.cups -= 1
    state.money += price
}

fun fill(scanner: Scanner, state: MachineState) {
    println("Write how many ml of water you want to add:")
    state.water += scanner.nextLine().toInt()

    println("Write how many ml of milk you want to add:")
    state.milk += scanner.nextLine().toInt()

    println("Write how many grams of coffee beans you want to add:")
    state.beans += scanner.nextLine().toInt()

    println("Write how many disposable cups you want to add:")
    state.cups += scanner.nextLine().toInt()

    println()
}

fun take(state: MachineState) {
    println("I gave you $${state.money}")
    println()
    state.money = 0
}

fun printState(state: MachineState) {
    println("The coffee machine has:")
    println("${state.water} ml of water")
    println("${state.milk} ml of milk")
    println("${state.beans} g of coffee beans")
    println("${state.cups} disposable cups")
    println("$${state.money} of money")
    println()
}

