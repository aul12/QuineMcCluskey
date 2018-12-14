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
}
