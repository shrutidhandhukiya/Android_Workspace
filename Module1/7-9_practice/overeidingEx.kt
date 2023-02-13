open class Bank
{
    companion object

    {

        open fun rate(): Int {
            return 0
        }
    }

    class Sbi : Bank() {

        override fun rate(): Int {
            return 3
        }
    }

    class Hdfc : Bank() {
        override fun rate(): Int {
            return 4
        }
    }

    open fun rate(): Int {
        TODO("Not yet implemented")
    }
}
fun main() {



}