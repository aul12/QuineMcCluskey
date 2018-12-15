/**
 * @author Paul
 * @version 0.1
 */

enum class LogicalValue {
    FALSE, TRUE, DONT_CARE
}

class MinTerm (vars : Int) {
    private var logicalValues: Array<LogicalValue> = Array(vars) { LogicalValue.FALSE}

    fun getRank() : Int {
        var count = 0
        logicalValues.forEach {
            if(it == LogicalValue.TRUE) {
                count++
            }
        }
        return count
    }

    fun set(i : Int, v : LogicalValue) {
        logicalValues[i] = v
    }

    fun set(i: Int, b : Boolean) {
        return this.set(i, if (b) LogicalValue.TRUE else LogicalValue.FALSE)
    }

    fun get(i: Int): LogicalValue {
        return this.logicalValues[i]
    }

    fun size(): Int {
        return logicalValues.size
    }

    fun getDifference(minTerm: MinTerm) : Int {
        assert(this.size() == minTerm.size())
        var diff = 0
        for (c in 0 until this.size()) {
            if (this.logicalValues[c] != minTerm.get(c)) {
                diff++
            }
        }
        return diff
    }

    override fun toString(): String {
        val sb : StringBuilder = java.lang.StringBuilder()
        for (lv in logicalValues) {
            when (lv) {
                LogicalValue.FALSE -> sb.append("0")
                LogicalValue.TRUE -> sb.append("1")
                LogicalValue.DONT_CARE -> sb.append("-")
            }
        }
        return sb.toString()
    }

    override fun equals(other: Any?): Boolean{
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as MinTerm

        if(this.size() != other.size()) {
            return false
        }

        for (i in 0 until this.size()) {
            if(logicalValues[i] != other.get(i)) {
                return false
            }
        }
        return true
    }

    override fun hashCode(): Int {
        var res = 0
        for (i in 0 until this.size()) {

            res = res*4 + when (get(i)) {
                        LogicalValue.FALSE -> 1
                        LogicalValue.TRUE -> 2
                        LogicalValue.DONT_CARE -> 3
                    }
        }
        return res
    }
}
