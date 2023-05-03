import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    var balance = readln().toInt()
    while (scanner.hasNextInt()) {
        // TODO
        val purchase: Int = scanner.nextInt()
        if (balance - purchase < 0) {
            println("Error, insufficient funds for the purchase. Your balance is $balance, but you need $purchase.")
        } else {
            balance -= purchase
            if (!scanner.hasNext()) {
                println("Thank you for choosing us to manage your account! Your balance is $balance.")
            }
        }
    }

    // TODO
}
