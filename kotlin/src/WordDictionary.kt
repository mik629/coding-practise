class WordDictionary() {

    /** Initialize your data structure here. */
    private val dict = TrieNode()

    /** Adds a word into the data structure. */
    fun addWord(word: String) {
        if (!word.isBlank() && !word.isEmpty()) {
            dict.insert(word)
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    fun search(word: String): Boolean {
        return dict.find(word)
    }

}

fun main() {
    val wd = WordDictionary()
    for (w in listOf("WordDictionary", "addWord", "addWord", "search", "search", "search", "search", "search", "search")) {
        wd.addWord(w)
    }

    for (w in listOf("a", "a", ".", "a", "aa", "a", ".a", "a.")) {
        println(wd.search(w))
    }
}

class TrieNode(private val isWord: Boolean = false, private val text: String = "", private val children: HashMap<Char, TrieNode> = hashMapOf()) {
    fun insert(word: String) {
        var next = this
        for (i in 0 until word.length) {
            next = next.insert(word[i], i == word.length - 1)
        }
    }

    private fun insert(char: Char, endsWord: Boolean = false): TrieNode {
        if (children.containsKey(char)) {
            return children[char]!!
        }

        val next = TrieNode(text = text + char, isWord = endsWord)
        children[char] = next
        return next
    }

    fun find(word: String): Boolean {
        var nextNode: TrieNode = this
        var nextChildren: HashMap<Char, TrieNode> = this.children
        for (char in word) {
            if (char != '.') {
                if (nextChildren.containsKey(char)) {
                    nextNode = nextChildren[char]!!
                    nextChildren = nextNode.children
                } else {
                    return false
                }
            } else {
                val allChildren = hashMapOf<Char, TrieNode>()
                for (node in nextChildren.values) {
                    allChildren.putAll(node.children)
                }
                nextChildren = allChildren
            }
        }
        return nextNode.isWord || nextChildren.isEmpty() || nextChildren.values.any { c -> c.isWord }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */