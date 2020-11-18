def helper(words, digits, mapping, result=[], current=[], index=0):
	if (index == len(digits)):
		candidate_word = "".join(current)
		if candidate_word in words:
			result.append(candidate_word)
		return
	digit = int(digits[index])
	for character in mapping[digit]:
		current.append(character)
		helper(words, digits, mapping, result, current, index+1)
		current.pop()
	return result

def t9(words, digits):
	mapping = {2:["a", "b", "c"], 3:["d", "e", "f"], 4:["g", "h", "i"],
	5:["j", "k", "l"], 6:["m", "n", "o"], 7:["p", "q", "r", "s"],
	8:["t", "u", "v"], 9:["w", "x", "y", "z"]}
	return helper(words, digits, mapping)

words = {"cat", "tree", "used"}
digits = "8733"
print(t9(words, digits))

class trieNode:
	def __init__(self):
		self.characters = {}

def createTrie(words):
	root = trieNode()
	for word in words:
		trav = root
		for c in word:
			if c not in trav.characters:
				trav.characters[c] = trieNode()
			trav = trav.characters[c]
	return root

def helper(trie, digits, mapping, result=[], current=[], index=0):
	if (index == len(digits)):
		candidate_word = "".join(current)
		if candidate_word in words:
			result.append(candidate_word)
		return
	digit = int(digits[index])
	for character in mapping[digit]:
		if (character not in trie.characters):
			continue
		current.append(character)
		helper(trie.characters[character], digits, mapping, result, current, index+1)
		current.pop()
	return result

def t9(words, digits):
	mapping = {2:["a", "b", "c"], 3:["d", "e", "f"], 4:["g", "h", "i"],
	5:["j", "k", "l"], 6:["m", "n", "o"], 7:["p", "q", "r", "s"],
	8:["t", "u", "v"], 9:["w", "x", "y", "z"]}
	return helper(words, digits, mapping)

words = {"cat", "tree", "used"}
digits = "8733"
trie = createTrie(words)
print(t9(trie, digits))
