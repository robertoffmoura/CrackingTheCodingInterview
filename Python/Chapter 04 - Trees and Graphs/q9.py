class Node:
	def __init__(self, value, left=None, right=None):
		self.value = value
		self.left = left
		self.right = right

def helper(remaining, result, current):
	if (len(remaining) == 0):
		result.append(current.copy())
	for node in set(remaining):
		remaining.remove(node)
		current.append(node.value)
		if (node.left is not None):
			remaining.add(node.left)
		if (node.right is not None):
			remaining.add(node.right)
		helper(remaining, result, current)
		if (node.left is not None):
			remaining.remove(node.left)
		if (node.right is not None):
			remaining.remove(node.right)
		current.pop()
		remaining.add(node)


def BSTSequences(node):
	remaining = set([node])
	result = []
	current = []
	helper(remaining, result, current)
	return result

root = Node(4, Node(2, Node(1), Node(3)), Node(5))
print(BSTSequences(root))
