class Node:
	def __init__(self, value, left=None, right=None):
		self.value = value
		self.left = left
		self.right = right

def validateBST(node):
	def validMinMax(node):
		if (node is None):
			return True, None, None
		mini, maxi = node.value, node.value
		if (node.left):
			leftValid, leftMin, leftMax = validMinMax(node.left)
			if not leftValid or not (leftMax <= node.value):
				return False, None, None
			mini = leftMin
		if (node.right):
			rightValid, rightMin, rightMax = validMinMax(node.right)
			if not rightValid or not (node.value < rightMin):
				return False, None, None
			maxi = rightMax
		return True, mini, maxi

	return validMinMax(node)[0]

root = Node(4, Node(2, Node(1), Node(3)), Node(6, Node(5), Node(7)))
print(validateBST(root))
