class CheckedArray {

    var data = IntArray(5)

   // var  data1= arrayOf<Int>(10,20,30,40,0)

  fun get()
    {

        data[0] = 10
        data[1] = 20
        data[2] = 30
        data[3] = 40
        data[4] = 0
    }

    fun check()
    {
        for(i in 0..4)
        {
            if(data[i] == 0)
            {
                println("array is empty")
            }
            else
            {
                println(data[i])
            }
        }
    }
}

fun main()
{
    var r = CheckedArray()
   r.get()
    r.check()

}