class Node:
	def __init__(self, value, left=None, right=None):
		self.value = value
		self.left = left
		self.right = right

def equalTrees(t1, t2):
	# True if t2 is identical to t1
	if (t1 is None and t2 is None):
		return True
	if ((t1 is None) != (t2 is None)):
		return False
	if (t1.value != t2.value):
		return False
	return equalTrees(t1.left, t2.left) and equalTrees(t1.right, t2.right)

def checkSubTree(t1, t2):
	# True if t2 is subtree of t1
	if equalTrees(t1, t2):
		return True
	if (t1.left is not None and checkSubTree(t1.left, t2)):
		return True
	if (t1.right is not None and checkSubTree(t1.right, t2)):
		return True
	return False

root2 = Node(4, Node(2, Node(1), Node(3)), Node(5))
root1 = Node(10, Node(4, Node(2, Node(1), Node(3)), Node(5)))
print(checkSubTree(root1, root2))
