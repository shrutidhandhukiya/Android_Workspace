class Element {

    var arr=IntArray(5)

    fun get(){

        for (i in 0..4){

           println("enter your Number :$i")
            var k= readLine()!!.toInt()
            arr[i]= k
            //arr[i]= readLine()!!.toInt()

        }

        for (i in 0..4){
            println(arr[i])
        }


    }

     fun find(){
         println("find Your position")
         var j = readLine()!!.toInt()
         println("your data is :" + arr[j])

      }


}

fun main() {

    var e1=Element()
     e1.get()
    e1.find()

}