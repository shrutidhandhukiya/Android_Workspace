import java.io.FileInputStream
import java.io.ObjectInput

import java.io.ObjectInputStream

   // Deserialize is readable

class  DeserializeEx{

    fun d1(){

      var obn = ObjectInputStream(FileInputStream("F://Shruti.txt"))

        var s: Student8 = obn.readObject() as Student8
        println(s.id)
        println(s.name)
    }
}

fun main() {

    var d= DeserializeEx()
    d.d1()
}