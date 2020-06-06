package main.kotlin

class CC(g: Graph) {
    private var count = 0
    private val id = IntArray(g.v)
    private val marked = Array(g.v) { false}


    init {
        for (i in 0 until g.v) {
            if (!marked[i]) {
                dfs(g, i)
                count++
            }
        }
    }

    private fun dfs(g: Graph, v: Int) {
        marked[v] = true
        id[v] = count
        for (u in g.adj(v)) {
            if (!marked[u]) {
                dfs(g, u)
            }
        }
    }

    fun isConnected(v: Int, u: Int): Boolean {
        return id(v) == id(u)
    }

    fun count(): Int {
        return count
    }

    fun id(v: Int): Int {
        return id[v]
    }
}