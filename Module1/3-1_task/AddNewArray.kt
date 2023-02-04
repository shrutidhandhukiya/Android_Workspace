class AddNewArray {

    fun a1(){
        val arr = intArrayOf(1,2,3,4,5)

        arr[4] = 10

        println("Elements in Array: ")

        for(element in arr) {
            print("$element")
        }
        println("")
    }
}

fun main() {
     var v1=AddNewArray()
    v1.a1()
}