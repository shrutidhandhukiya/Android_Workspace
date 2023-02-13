import java.io.FileOutputStream
import java.io.ObjectOutput
import java.io.ObjectOutputStream
       // not Readeble file
class  SerializeEx{

    fun s1()
    {
        var s1= Student8(101,"tops")
        var fout=FileOutputStream("F://shruti.txt")
        var out=ObjectOutputStream(fout)
        out.writeObject(s1)
        println("Success")

    }
}

fun main() {

     var s2=SerializeEx()
    s2.s1()
}