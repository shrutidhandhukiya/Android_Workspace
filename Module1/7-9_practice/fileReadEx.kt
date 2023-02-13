
import java.io.FileInputStream
import java.io.FileReader

fun main() {

   var fin = FileInputStream("F://topsXyz.txt")
   var byteArray: ByteArray = ByteArray(fin.available())

  // byteArray=variable , ByteArray= Object

   fin.read(byteArray)
   var  str: String= String(byteArray)
   println(str)

}