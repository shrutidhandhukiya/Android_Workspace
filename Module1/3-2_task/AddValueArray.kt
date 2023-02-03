class AddValueArray {

    fun value(){

        var add= arrayOf<String>("python","java","Android","kotlin","etc")

        add[2]="Shruti"
          for (i in add)
              println(i)

    }



}
fun main() {
    var v1= AddValueArray()
    v1.value()
}