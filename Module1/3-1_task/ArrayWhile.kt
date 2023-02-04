class ArrayWhile {

    var arr = IntArray(5)

    var i = 0

    fun all() {

        while (i <= 4) {

            println("enter your data $i")
            arr[i] = readLine()!!.toInt()
            i++

        }
    }

}

fun main() {
    val v1 = ArrayWhile()
    v1.all()

}