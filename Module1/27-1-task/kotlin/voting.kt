fun main (){

    println("enter your user :")
    var age= readLine()!!.toInt()


    if (age>=18)
    {
        println("Eligible to vote ")

      //nested if

      if (age>=60)
      {
          println("You are under senior citizen category")
      }
        else
      {
          println("You are under young category")
      }

    }
    else
    {
        println(" not Eligible to vote ")
    }

}