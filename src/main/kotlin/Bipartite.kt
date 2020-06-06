package main.kotlin

fun isBipartite(g: Graph): Boolean {
    val part1: MutableSet<Int> = mutableSetOf()
    val part2: MutableSet<Int> = mutableSetOf()
    for (v in 0 until g.v) {
        if (!part2.contains(v)) {
            part1.add(v)
            part2.addAll(g.adj(v))
        }
    }
    for (v in part1) {
        for (u in part1) {
            if (v != u && g.adj(v).contains(u)) {
                return false
            }
        }
    }
    for (v in part2) {
        for (u in part2) {
            if (v != u && g.adj(v).contains(u)) {
                return false
            }
        }
    }
    return true
}

fun main() {
    val g1 = Graph(5)
    for (i in 1 until  5) {
        g1.addEdge(0, i)
    }
    println(isBipartite(g1))

    g1.addEdge(1, 2)
    println(isBipartite(g1) == false)

    val g2 = Graph(3)
    g2.addEdge(0, 1)
    g2.addEdge(1, 2)
    println(isBipartite(g2))
}
