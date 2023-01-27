fun main(){

     println("enter your subject 1:")
     var sub1= readLine()!!.toFloat()

     println("enter your subject 2:")
     var sub2= readln().toFloat()

     println("enter your subject 3:")
     var sub3= readln().toFloat()

     println("enter your subject 4:")
     var sub4= readln().toFloat()

    println("enter your subject 5:")
    var sub5= readln().toFloat()

    var per = (sub1+sub2+sub3+sub4+sub5)*100/500
    println("percentage of marks: $per")
}

