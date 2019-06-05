package dependency_graph

fun main() {
    println(
            findBuildOrder(
                    mutableListOf("a", "b", "c", "d", "e", "f"),
                    mutableListOf("a" to "d", "f" to "b", "b" to "d", "f" to "a", "d" to "c")
            ).joinToString { it.name }
    )
}

fun findBuildOrder(projects: MutableList<String>, dependencies: MutableList<Pair<String, String>>): MutableList<Project> {
    return orderProjects(buildGraph(projects, dependencies).nodes)
}

fun buildGraph(projects: MutableList<String>, dependencies: MutableList<Pair<String, String>>): Graph {
    val graph = Graph()
    for (project in projects) {
        graph.getOrCreateNode(project)
    }

    for (dependency in dependencies) {
        graph.addEdge(dependency.first, dependency.second)
    }
    return graph
}

fun orderProjects(projects: MutableList<Project>): MutableList<Project> {
    val order = mutableListOf<Project>()
    addNonDependent(projects, order)

    var toBeProcessed = 0
    while (toBeProcessed < order.size) {
        val current = order[toBeProcessed]
        val children = current.children
        for (child in children) {
            child.decDependenciesCount()
        }
        addNonDependent(children, order)
        toBeProcessed++
    }
    return order
}

fun addNonDependent(projects: MutableList<Project>, order: MutableList<Project>) {
    for (project in projects) {
        if (project.dependenciesCount == 0) {
            order.add(project)
        }
    }
}