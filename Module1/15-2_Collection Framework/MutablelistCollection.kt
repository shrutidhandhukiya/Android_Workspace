import jdk.internal.org.objectweb.asm.tree.analysis.Value

fun main() {

   // ***** HasMap *******

    /*var hasMap = HashMap<Int,String>()
    hasMap.put(1,"Shruti")
    hasMap.put(2,"Shruti")
    hasMap.put(3,"Shruti")


    for (m:Map.Entry<Int,String> in  hasMap.entries)
    {
        println(m.key)
        println(m.value)
    }
       //println(hasMap)
*/

    // **** hasMapOf()********

   /* var m1= hashMapOf<String,Int>()
    m1.put("Shruti",1)

    println(m1)
    */


   // ******* MutableMapOf **********

    var a = mutableMapOf<Int ,String>()
    a.put(1,"Shruti")
    a.put(2,"android")
    a.put(3,"kotlin")
    a.put(4,"java")

    for (m:Map.Entry<Int,String> in a.entries)
    {
        println(m.key)
        println(m.value)

    }
  // println(a)
        // println(a.get(1))




    }