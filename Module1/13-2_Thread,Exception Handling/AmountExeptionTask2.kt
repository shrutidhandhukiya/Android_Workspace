class Account
{

    fun checked()
    {
        println("Enter Your Account Balance:")
        var a= readLine()!!.toInt()

        println("Enter withdraw amount : ")
        var a1= readLine()!!.toInt()

         if (a<a1)
            {
                var c= a1-a
                println(c)

                throw Exception("Customer withdraw is high as Balance Account.")
            }
            else
            {

                println("Transaction is Done")
            }
    }

}

fun main() {

    var b1= Account()
    b1.checked()

}