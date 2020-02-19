package dependency_graph

class Project(val name: String) {
    val children = mutableListOf<Project>()
    val neighbours = mutableSetOf<String>()
    var dependenciesCount = 0

    fun addNeighbour(node: Project) {
        if (!neighbours.contains(node.name)) {
            children.add(node)
            neighbours.add(node.name)
            node.incDependenciesCount()
        }
    }

    fun incDependenciesCount() {
        dependenciesCount++
    }

    fun decDependenciesCount() {
        dependenciesCount--
    }
}