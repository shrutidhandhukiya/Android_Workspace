import kotlin.concurrent.thread

class Messenger
{
    fun send(msg:String)
    {
      println("sending $msg")

        Thread.sleep(1000)

        println("$msg sent " )
    }
}
class Sender(var msg: String, messenger: Messenger) :Thread()
{
    override fun run()
    {
        {
           
       }

    }

}