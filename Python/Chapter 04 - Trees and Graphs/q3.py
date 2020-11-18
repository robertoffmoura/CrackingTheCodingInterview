class Node:
	def __init__(self, value, left=None, right=None):
		self.value = value
		self.left = left
		self.right = right

def listOfDepths(root):
	nodesWithDepth = {}

	def fill(node, depth=0):
		if (node is None):
			return
		if depth not in nodesWithDepth:
			nodesWithDepth[depth] = []
		nodesWithDepth[depth].append(node.value)
		fill(node.left, depth+1)
		fill(node.right, depth+1)

	fill(root)
	return nodesWithDepth

root = Node(1, Node(2, Node(4), Node(5)), Node(3, Node(6), Node(7, Node(8, Node(10)), Node(9))))
print(listOfDepths(root))
