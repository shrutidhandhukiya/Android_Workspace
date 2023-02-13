class MyFirstClass
{
    fun passed(marks:Int):String{

        if (marks>33)
         {
            println("pass")
         }
        else
         {
             println("Fail")
         }

        return (marks.toString())
    }

}

fun main() {
    var m1=MyFirstClass()
    println("passed:" + m1.passed(22))
    println("ScholarShip:"+m1.Scholarship(99))
}
infix fun MyFirstClass.Scholarship(marks: Int):Boolean{

    return marks>90

}
