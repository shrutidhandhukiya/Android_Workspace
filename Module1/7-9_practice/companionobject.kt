class ComObj
{
   companion object {


       fun add1(a: Int, b: Int): Int {

           return a + b

       }

       fun add1(c: Double, d: Double): Double {

           return c * d
       }

   }
}

fun main() {

    println(ComObj.add1(2,3))
    println(ComObj.add1(2.00,3.00))

}