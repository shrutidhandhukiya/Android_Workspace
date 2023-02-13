

class LambdaFunction{

    fun num(a:Int,b:Int, str:(Int)-> Unit)
    {
        val sum=a+b
        str(sum)
    }
}

fun main() {
    val my = LambdaFunction()
    val myLambda: (Int)-> Unit= {s :Int -> println(s) }
    my.num(4,5,myLambda)
}