// method OverLoading
     // Same name but number of argument or type is different.

class MoEx
{
    fun add1(a:Int,b:Int): Int
     {

         return a+b
     }

    fun add1(c:Double,d: Double): Double
    {
        return c*d
    }
}


fun main() {

    val m1 = MoEx()

    m1.add1(2,3,)
    m1.add1(4.00,4.00)

}