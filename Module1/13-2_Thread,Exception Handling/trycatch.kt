class checkdata {
    fun Detail() {

        // logic in Error generate catch block.
        try {
            var num = 25/ 0

            println(num)
        }
        catch (f: Exception)
        {
            f.printStackTrace()
        }
        finally
        {
            println("Executed")
        }
    }
}

fun main() {

    var c1=checkdata()
    c1.Detail()
}
