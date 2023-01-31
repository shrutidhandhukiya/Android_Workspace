fun main() {

    println("enter you number : ")
    var num = readLine()!!.toInt()

    var result = false

    for (i in 2..num / 2) {
         // not prime condition

        if (num % i == 0) {
            result = true
        }
    }
    if (result){
        println("prime")
    }
    else
    {
        println("not prime")
    }
}