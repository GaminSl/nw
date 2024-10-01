fun main() {
    val num = readLine()!!.toInt()

    val sravn = num in A..B
    println("resultat $sravn!")
}
const val A = 100
const val B = 200