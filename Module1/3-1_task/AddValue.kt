class AddValue {

    var Arr=  IntArray(5)


     fun get(){

         for (i in 0..4){

             println("Enter Your Value: $i")
             Arr[i]= readLine()!!.toInt()
         }

     }

    fun add()
    {
        println("position  for  add new value : ")
        var j= readLine()!!.toInt()

        println("Enter your new value:")
        Arr[j]= readLine()!!.toInt()

        println(" Array update your Value:" + Arr[j])
    }

    fun print(){
        for (i in 0..4){
            println("your Array element $i : " + Arr[i])
        }
    }
}

fun main() {
    var a1=AddValue()
    a1.get()
    a1.add()
    a1.print()

}