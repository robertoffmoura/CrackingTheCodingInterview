class Node:
	def __init__(self, value, left=None, right=None):
		self.value = value
		self.left = left
		self.right = right
		self.parent = None

	def addLeftChild(self, node):
		self.left = node
		node.parent = self

	def addRightChild(self, node):
		self.right = node
		node.parent = self

def successor(node):
	if node.right is None:
		trav = node
		while (trav.parent is not None and trav.parent.left != trav):
			trav = trav.parent
		return trav.parent
	trav = node.right
	while (trav.left is not None):
		trav = trav.left
	return trav

nodes = [Node(i) for i in range(8)]
nodes[2].addLeftChild(nodes[1])
nodes[3].addLeftChild(nodes[2])
nodes[3].addRightChild(nodes[5])
nodes[5].addLeftChild(nodes[4])
nodes[5].addRightChild(nodes[6])
nodes[7].addLeftChild(nodes[3])
for i in range(1,8):
	suc = successor(nodes[i])
	print(suc.value if suc is not None else "None")
