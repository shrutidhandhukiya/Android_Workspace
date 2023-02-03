class CheckedArray {

    fun s1() {

        var sub = arrayOf<String>("shruti","dimple")

        for (i in sub) {
            println(i)

            if (i.isNotEmpty()) {
                println("print element")
            } else
                println("Array is empty")
        }
    }
}

fun main() {
    var s1= CheckedArray()
    s1.s1()
}