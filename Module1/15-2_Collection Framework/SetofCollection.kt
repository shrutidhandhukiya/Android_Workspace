fun main() {

   // ***** SetOf() ******

 /*   var s= setOf(1,2,3,4,"A","v","d") // immutable

   // println(s)

    // println( s.elementAt(2))
      // println( s.indexOf(2))
      // println( s.lastIndexOf("v"))
     //s.elementAt(2)
*/

    // ***** mutableSetOf *******

     var s = mutableSetOf<String>()

    s.add("Shruti")
    s.add("kajal")
    s.add("jyoti")
    s.add("Shruti")

    //  s.remove("kajal")
   // s.removeAll(s)

    println(s)

    var s1= mutableSetOf<String>()
    s1.add("1")
    s1.add("2")
    s1.add("3")

   println(s1)

    s1.addAll(s)












}

