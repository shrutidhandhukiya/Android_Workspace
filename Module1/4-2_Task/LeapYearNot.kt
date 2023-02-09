fun main() {

    println("Enter Your Leap Year: ")
    var year = readLine()!!.toInt()

    if (year % 4 == 0) {
        println("Leap Year")
    } else {
        println("Not Leap Year ")
    }

}