package cinema

const val SMALL_ROOM: Int = 60
const val TICKET_PRICE: Int = 10
const val CHEAP_TICKETS: Int = 8
var cheapTicketsSold: Int = 0
var expensiveTicketsSold: Int = 0
val chairs = mutableListOf<MutableList<Char>>()
var rows: Int = 0
var seats: Int = 0
var selectedRow: Int = 0
var selectedSeat: Int = 0
var expensiveSeats: Int = 0
var cheapSeats: Int = 0
fun showStatistic() {
    val ticketsSold: Int = expensiveTicketsSold + cheapTicketsSold
    val percentage = ticketsSold / (rows * seats).toDouble() * 100
    val currentIncome: Int = expensiveTicketsSold * TICKET_PRICE + cheapTicketsSold * CHEAP_TICKETS
    val totalIncome: Int = TICKET_PRICE * expensiveSeats + CHEAP_TICKETS * cheapSeats
    println(
        """
            Number of purchased tickets: ${cheapTicketsSold + expensiveTicketsSold}
            Percentage: ${String.format("%.2f", percentage)}%
            Current income: ${'$'}$currentIncome
            Total income: ${'$'}$totalIncome
            
        """.trimIndent()
    )
}
fun createChairs() {
    println("Enter the number of rows:")
    rows = readln().toInt()
    println("Enter the number of seats in each row:")
    seats = readln().toInt()
    repeat(rows) {
        chairs.add(MutableList(seats) { 'S' })
    }
    if (seats * rows <= SMALL_ROOM) {
        expensiveSeats = seats * rows
    } else {
        expensiveSeats = seats * (rows / 2)
        cheapSeats = seats * (rows - rows / 2)
    }
}

fun showSeats() {
    println("Cinema:")
    print("  ")
    for (s in 1..seats) print("$s ")
    println()
    for (row in 1..rows) {
        print("$row ")
        for (seat in 1..seats) {
            print("${chairs[row - 1][seat - 1]} ")
        }
        println()
    }
}
fun buyTicket() {
    while (true) {
        println("Enter a row number:")
        selectedRow = readln().toInt()
        println("Enter a seat number in that row:")
        selectedSeat = readln().toInt()
        try {
            if (chairs[selectedRow - 1][selectedSeat - 1] == 'S') {
                break
            }
        } catch (e: Exception) {
            println("Wrong input!")
        }
        println("That ticket has already been purchased!")
    }

    if (seats * rows <= SMALL_ROOM || selectedRow <= rows / 2) {
        println("Ticket price: \$$TICKET_PRICE")
        expensiveTicketsSold++
    } else {
        println("Ticket price: \$$CHEAP_TICKETS")
        cheapTicketsSold++
    }
    chairs[selectedRow - 1][selectedSeat - 1] = 'B'
}
fun main() {
    createChairs()
    var exit = false
    while (!exit) {
        println(
            """
        1. Show the seats
        2. Buy a ticket
        3. Statistics
        0. Exit
            """.trimIndent()
        )
        when (readln().toInt()) {
            1 -> showSeats()
            2 -> buyTicket()
            3 -> showStatistic()
            0 -> exit = true
        }
    }
}
