import java.io.FileOutputStream

fun main() {
    
    val data="hello word"
    val fout=FileOutputStream("F://topsXyz.txt")
    fout.write(data.toByteArray())
    println("Success")
}