fun main() {

    println("Enter your value:")
    var n1 = readLine()!!.toInt()

    println("Enter your Value:")
    var n2= readLine()!!.toInt()

    println("Enter Your Value:")
    var n3= readLine()!!.toInt()


    if (n1>n2) {

        if (n1 > n3) {
            println("Your Number Maximum $n1")
        }

      }
       else if (n2>n3)

      {
            if (n2>n1)
            {
                println("number Maximum $n2")
           }
        }
    else
    {
        println("number Maximum $n3")
    }


}