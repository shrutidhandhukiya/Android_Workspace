fun main() {

    var fac = 1

    println("Enter Your Value :")
    var a1 = readLine()!!.toInt()


    for (i in 1..a1) {
        fac *= i
       //
    // fac=fac*i
    }

    println("factorial Number is $fac ")

}

