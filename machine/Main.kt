package machine

import java.util.Scanner

enum class MachineState {
    CHOOSING_ACTION,
    CHOOSING_COFFEE,
    FILLING_WATER,
    FILLING_MILK,
    FILLING_BEANS,
    FILLING_CUPS,
}

class CoffeeMachine() {
    private val mainPrompt = "Write action (buy, fill, take, remaining, exit): "
    var water: Int = 400
    var milk: Int = 540
    var beans: Int = 120
    var cups: Int = 9
    var money: Int = 550
    var state: MachineState = MachineState.CHOOSING_ACTION

    fun process(input: String): String {
        if (input == "exit") return "exit"

        return when (state) {
            MachineState.CHOOSING_ACTION -> {
                when (input) {
                    "buy" -> {
                        state = MachineState.CHOOSING_COFFEE
                        "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: "
                    }
                    "fill" -> {
                        state = MachineState.FILLING_WATER
                        "Write how many ml of water you want to add:"
                    }
                    "take" -> handleTake()
                    "remaining" -> handleRemaining()
                    else -> mainPrompt
                }
            }

            MachineState.CHOOSING_COFFEE -> handleBuy(input)
            MachineState.FILLING_WATER -> handleFillingWater(input)
            MachineState.FILLING_MILK -> handleFillingMilk(input)
            MachineState.FILLING_BEANS -> handleFillingBeans(input)
            MachineState.FILLING_CUPS -> handleFillingCups(input)
        }
    }

    private fun handleBuy(choice: String): String {
        state = MachineState.CHOOSING_ACTION
        val result = when (choice) {
            "1" -> brew(250, 0, 16, 4)
            "2" -> brew(350, 75, 20, 7)
            "3" -> brew(200, 100, 12, 6)
            "back" -> ""
            else -> "Invalid option.\n"
        }

        return "$result\n$mainPrompt"
    }

    private fun brew(waterReq: Int, milkReq: Int, beansReq: Int, price: Int): String {
        return when {
            water < waterReq -> "Sorry, not enough water!\n"
            milk < milkReq -> "Sorry, not enough milk!\n"
            beans < beansReq -> "Sorry, not enough beans!\n"
            cups < 1 -> "Sorry, not enough cups!\n"
            else -> {
                water -= waterReq
                milk -= milkReq
                beans -= beansReq
                cups -= 1
                money += price
                "I have enough resources, making you a coffee!\n"
            }
        }
    }

    private fun handleFillingWater(input: String): String {
        water += input.toInt()
        state = MachineState.FILLING_MILK

        return "Write how many ml of milk you want to add:"
    }

    private fun handleFillingMilk(input: String): String {
        milk += input.toInt()
        state = MachineState.FILLING_BEANS

        return "Write how many grams of coffee beans you want to add:"
    }

    private fun handleFillingBeans(input: String): String {
        beans += input.toInt()
        state = MachineState.FILLING_CUPS

        return "Write how many disposable cups you want to add:"
    }

    private fun handleFillingCups(input: String): String {
        cups += input.toInt()
        state = MachineState.CHOOSING_ACTION

        return mainPrompt
    }

    private fun handleTake(): String {
        val cash = money
        money = 0
        return "I gave you $$cash\n\n$mainPrompt"
    }

    private fun handleRemaining(): String {
        return """
        The coffee machine has:
        $water ml of water
        $milk ml of milk
        $beans g of coffee beans
        $cups disposable cups
        $$money of money

        $mainPrompt
    """.trimIndent()
    }
}

fun main() {
    val coffeeMachine = CoffeeMachine()
    var output = coffeeMachine.process("")
    println(output.trim())

    val scanner = Scanner(System.`in`)

    while (true) {
        val input = scanner.nextLine()
        output = coffeeMachine.process(input)

        if (output == "exit") break

        println(output.trim())
    }
}
