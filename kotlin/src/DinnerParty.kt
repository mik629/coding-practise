fun findDinnerParties(friends: MutableList<Int>, tableSize: Int) {
    val groups = mutableListOf<MutableList<Int>>()
    combineFriends(friends, tableSize, group = mutableListOf(), groups = groups)
    print(groups)
}

fun combineFriends(
        friends: MutableList<Int>,
        tableSize: Int,
        pos: Int = 0,
        group: MutableList<Int>,
        groups: MutableList<MutableList<Int>>
) {
    if (group.size == tableSize) {
        groups.add(group)
    } else if (pos < friends.size) {
        combineFriends(friends, tableSize, pos + 1, group, groups)

        val newGroup = group.toMutableList()
        newGroup.add(friends[pos])

        combineFriends(friends, tableSize, pos + 1, newGroup, groups)
    }
}

fun main() {
    findDinnerParties(mutableListOf(1, 2, 3, 4, 5), 3)
}