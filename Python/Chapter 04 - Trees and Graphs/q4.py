class Node:
	def __init__(self, value, left=None, right=None):
		self.value = value
		self.left = left
		self.right = right

def balancedAndHeight(node):
	if (node is None):
		return True, 0
	leftBalanced, leftHeight = balancedAndHeight(node.left)
	rightBalanced, rightHeight = balancedAndHeight(node.right)
	if (not leftBalanced or not rightBalanced):
		return False, None
	if (abs(leftHeight - rightHeight) > 1):
		return False, None
	return True, max(leftHeight, rightHeight) + 1

def checkBalanced(root):
	return balancedAndHeight(root)[0]

root = Node(1, Node(2, Node(4), Node(5)), Node(3, Node(6), Node(7, Node(8), Node(9))))
print(checkBalanced(root))
