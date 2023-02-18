import java.util.Stack

class StackEx
{

      // push Entry
    fun pushData(s: Stack<Int>, n:Int ){

        s.push(n)
        println(n)

    }
    // pop means Exit
    fun popData(e:Stack<Int>){

        var i:Int  = e.pop()

        println(i)
        println(e)
    }
}

fun main() {
    // Stack object
    var s1= Stack<Int>()
    // class object
    var s2 = StackEx()

    s2.pushData(s1,10)
    s2.pushData(s1,20)
    s2.pushData(s1,30)
    s2.pushData(s1,40)

    try {
        s2.popData(s1)
        s2.popData(s1)
        s2.popData(s1)
        s2.popData(s1)
        s2.popData(s1)

    }
   catch (e:Exception)
   {
       println("Empty Stack")
   }
    finally {
        println("Executed")
    }
}