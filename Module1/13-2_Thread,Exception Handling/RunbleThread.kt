class B1 :Runnable
{
    override fun run()
    {
     for (i in 1..10){
         println("Thread A: $i")
     }
    }
}

class  B2 :Runnable
{
    override fun run(){
        for (i in 1..10)
        {

            println("Thread B: $i")
        }
    }
}

fun main() {
     var v1=  Thread(B1())
    var v2= Thread(B2())

    v1.start()
    v2.start()
}

