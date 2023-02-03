class ArrayWhile {

    fun all(){

        var i=0

        var num= arrayOf<String>("python","java","Android","kotlin","etc")

         while (i <= num.size)
         {
             println(num[i])
             i++
         }

    }

}

fun main() {
    val v1 = ArrayWhile()
    v1.all()
}