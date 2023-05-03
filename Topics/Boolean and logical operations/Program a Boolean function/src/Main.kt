fun main() {
    val x = readlnOrNull().toBoolean() // read other values in the same way
    // write your code here
    val y = readlnOrNull().toBoolean()
    val z = readlnOrNull().toBoolean()

    println(!(x&&y) || z)
}
