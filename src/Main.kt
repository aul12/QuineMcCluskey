import java.io.FileInputStream
import java.util.*

/**
 * @author Paul
 * @version 0.1
 */

fun getClustered(terms : MutableList<MinTerm>) {
    terms.sortBy { term -> term.getRank() }
    //@TODO complete me
}

fun main(args : Array<String>) {
    assert(args.size == 1)
    val inputStream = Scanner(FileInputStream(args[0]))
    val initalTable = mutableListOf<MinTerm>()
    while (inputStream.hasNext()) {
        val line = inputStream.nextLine()
        val items = line.split(" ")
        if (items.last() == "1") {
            initalTable.add(MinTerm(items.size - 1))
            for (i in 0 until items.size-1) {
                initalTable.last().set(i, items[i]=="1")
            }
        }
    }
    System.out.println(initalTable)

}
