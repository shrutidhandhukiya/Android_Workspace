class  MyClass{

    fun pass(marks:Int):Boolean{

        return  marks>35
    }
}


fun main()
{
     var m1 = MyClass()
     println("pass :" + m1.pass(95))
     println("ScholarShip:"+m1.isScholar(99))
}


fun  MyClass.isScholar(mark:Int):Boolean{
    return mark>90
}

