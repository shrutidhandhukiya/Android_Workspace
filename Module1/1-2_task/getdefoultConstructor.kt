class DefaultConstructor(var n1:Int,var n2:Int) {


    fun data() {

        println("Enter your number:")
        var n1 = readLine()!!.toInt()

        println("Enter your number")
        var n2 = readln().toInt()

        var n3 = n1 + n2
        println("Enter your number $n3")
    }
}

    fun main(){

     var  a1= DefaultConstructor(2,3)
     a1.data()



    }
