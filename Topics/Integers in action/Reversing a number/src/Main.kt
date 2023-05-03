fun main() {
    // put your code here
    val input: Int = readln().toInt()
    val last: Int = input % 10
    val second: Int = (input - last) % 100 /10
    val first: Int = input / 100
    println("$last$second$first")
}
