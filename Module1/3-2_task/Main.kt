class List(){


       fun d1(){

          var i =1
           var subject= arrayOf<String>("python","java","Android","kotlin","etc")

            for (i in subject){
              println(i)
          }
       }

}
fun main() {

    var l1 = List()
     l1.d1()

}