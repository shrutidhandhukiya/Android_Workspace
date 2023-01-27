fun main(){

    println("enter your leapYear")

    var leap= readLine()!!.toInt()

    if (leap%4==0)
    {
        println(" year is leap year:$leap")
    }
   else
    {
        println("year is not leap year:$leap")
    }
}