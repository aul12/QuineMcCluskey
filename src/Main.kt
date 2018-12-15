import java.io.FileInputStream
import java.util.*

/**
 * @author Paul
 * @version 0.1
 */

/**
 * This function creates an array of list of a tuple of a minTerm and a boolean.
 * Each tuple is a minTerm and boolean representing whether the corresponding minTerm is used.
 * The minTerms at each array element are all of equal rank, the array is ordered by rank.
 */
fun getClustered(terms : MutableList<MinTerm>) : Array<MutableList<Pair<MinTerm, Boolean>>> {
    val ret = Array(terms[0].size() + 1) { mutableListOf<Pair<MinTerm, Boolean>>()}
    for (term in terms) {
        ret[term.getRank()].add(Pair(term, false))
    }
    return ret
}

/**
 * This function merges two minTerms of the same size and replaces all differences with DONT_CARES.
 */
fun mergeMinTerms(t1 : MinTerm, t2 : MinTerm): MinTerm {
    assert(t1.size() == t2.size())
    val ret = MinTerm(t1.size())
    for (i in 0 until ret.size()) {
        if(t1.get(i) != t2.get(i)) {
            ret.set(i, LogicalValue.DONT_CARE)
        } else {
            ret.set(i, t1.get(i))
        }
    }
    return ret
}

fun main(args : Array<String>) {
    assert(args.size == 1)
    val inputStream = Scanner(FileInputStream(args[0]))
    var table = mutableListOf<MinTerm>()
    while (inputStream.hasNext()) {
        val line = inputStream.nextLine()
        val items = line.split(" ")
        if (items.last() == "1") {
            table.add(MinTerm(items.size - 1))
            for (i in 0 until items.size-1) {
                table.last().set(i, items[i]=="1")
            }
        }
    }

    val nonModifiable = mutableListOf<MinTerm>()
    var combinationPossible = true
    while (combinationPossible) {
        combinationPossible = false

        val clustered = getClustered(table)
        val newTable = mutableListOf<MinTerm>()

        // Simplify expressions by comparing them with expressions with a rank difference of 1
        for (ci in 1 until clustered.size) {
            for (li in 0 until clustered[ci-1].size) {
                for (ti in 0 until clustered[ci].size) {
                    if (clustered[ci-1][li].first.getDifference(clustered[ci][ti].first) <= 1) {
                        combinationPossible = true
                        newTable.add(mergeMinTerms(clustered[ci-1][li].first,
                            clustered[ci][ti].first))
                        clustered[ci-1][li] = clustered[ci-1][li].copy(clustered[ci-1][li].first, true)
                        clustered[ci][ti] = clustered[ci][ti].copy(clustered[ci][ti].first, true)
                    }
                }
            }
        }

        // Add all expressions which cannot be merged into a list
        for (ci in 0 until clustered.size) {
            for (i in 0 until clustered[ci].size) {
                if(!clustered[ci][i].second) {
                    nonModifiable.add(clustered[ci][i].first)
                }
            }
        }

        /*
         * Remove duplicates.
         * Example: 10- + 00- = -0- = -01 + -00
         */
        table = newTable.distinct().toMutableList()
    }
    println(nonModifiable)
}
