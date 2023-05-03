fun main() {
    // write your code here
    val input: Int = readln().toInt()
    when {
        input < 0 -> println("negative")
        input == 0 -> println("zero")
        input > 0 -> println("positive")
    }
}
