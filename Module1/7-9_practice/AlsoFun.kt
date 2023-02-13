class Person{
     var name=""
     var email=""
     var age= Int

}

fun main() {

    Person().also {
        it.name = "Shruti"
        it.email = "shr@gmail.com"
        println(it)

    }

}
