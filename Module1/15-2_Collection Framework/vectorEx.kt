import java.util.Vector

class  VectorEx
{

    fun execute(){

        var v =Vector<String>(5)

        // Size
        v.addElement("Kotlin")
        v.addElement("B")
        v.addElement("B")
        v.addElement("B")
        v.addElement("B")
        v.addElement("B")
        v.addElement("B")
        v.addElement("B")
        v.addElement("B")
        v.addElement("B")
        v.addElement("B")
        v.addElement("B")
        v.addElement("B")
        v.addElement("B")
        v.addElement("B")

        println("Capacity"+v.capacity())
        println("Size :"+ v.size)

        if (v.contains("B"))
        {
            println("Yes")
        }
        else
        {
            println("No")
        }

    }


}

fun main() {

    var v = VectorEx()
    v.execute()

}