package main.kotlin

data class Graph(val v: Int) {
    private val adj: Array<MutableSet<Int>> = Array(v) { HashSet<Int>()};

    fun addEdge(v: Int, u: Int) {
        adj[v].add(u)
        adj[u].add(v)
    }

    fun adj(v: Int): Set<Int> {
        return adj[v].toHashSet()
    }
}
