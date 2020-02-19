package dependency_graph

class Graph {
    val nodes = mutableListOf<Project>()
    private val cache = mutableMapOf<String, Project>()

    fun getOrCreateNode(name: String): Project {
        if (!cache.containsKey(name)) {
            val project = Project(name)
            cache[name] = project
            nodes.add(project)
            return project
        }
        return cache[name]!!
    }

    fun addEdge(start: String, end: String) {
        getOrCreateNode(start).addNeighbour(getOrCreateNode(end))
    }
}