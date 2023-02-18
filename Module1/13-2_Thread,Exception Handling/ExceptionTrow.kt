
import kotlin.ArithmeticException

class Throw
{
    fun  checked(age:Int){

        if (age<18)
        {
            throw ArithmeticException("Age is not Valid")
        }
        else
        {
            println("Eligible vote")
        }
    }
}

fun main() {
    var t1= Throw()
    t1.checked(15)

}