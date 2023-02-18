 class A1 : Thread()
{

    override fun run(){

        for (i in 1..10)
        {
            println(" Thread is A:$i")
        }

    }
}

class A2:Thread()
{
    override fun run()
    {

        var d= A1()
        synchronized(d)
        {
            for (i in 1..10) {
                println(" Thread is B:$i")
            }

        }
    }

}

fun main() {

    val thread1 = A1()
    val thread2 =  A2()

    thread1.start()
    thread2.start()
}

