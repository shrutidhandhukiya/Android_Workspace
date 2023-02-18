import java.util.ArrayList

class MyList {
    fun detail() {
        var list1 = ArrayList<String>()
        list1.add("shruti")
        list1.add("java")
        list1.add("python")
        list1.add("Android")


        var list2 = ArrayList<String>()
        list2.add("c++")
        list2.add("C")
        list2.add("Android")

       // list1.addAll(list2)
        //println(list1)

        list2.addAll(list1)

        println(list2)

        // list1.retainAll(list2)

    //  list1.remove("python")
        // list1.removeAt(2)
        //  list1.removeAll(list1)

        //  list2.addAll(list1)

        /* var iterator:Iterator<String> = list1.iterator()

        while (iterator.hasNext()){
            println(iterator.next())
        }
    }*/
    }
}
fun main() {

    var m= MyList()
    m.detail()
}