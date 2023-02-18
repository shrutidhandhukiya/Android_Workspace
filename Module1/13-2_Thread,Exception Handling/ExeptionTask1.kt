class Scanner {

    fun check() {

        var num:IntArray
        var Arr = IntArray(10)

        for (i in 1..9) {
            println("Enter your Value :")
            Arr[i] = readLine()!!.toInt()

                    try {
                        if (Arr[i] < 10 || Arr[i] > 40)
                        {
                           // throw Exception("")
                            throw  MyException()
                        }

                    }
                    catch(e:Exception)
                    {
                        println("error occurs  due to wrong value")
                    }
                    continue
                }


        for(i in 1..9)
        {
            println(Arr[i])
        }
    }
}
fun main() {

    var s1= Scanner()
    s1.check()
}