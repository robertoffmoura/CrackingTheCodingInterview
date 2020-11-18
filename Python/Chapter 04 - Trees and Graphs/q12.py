class Node:
	def __init__(self, value, left=None, right=None):
		self.value = value
		self.left = left
		self.right = right

def pathsWithSum(node, k, seen={0:1}, last=0):
	if (node is None):
		return 0
	result = 0
	last += node.value
	searchedValue = last - k
	if searchedValue in seen:
		result += seen[searchedValue]
	seen[last] = (1 + seen[last] if last in seen else 1)
	result += pathsWithSum(node.left, k, seen, last)
	result += pathsWithSum(node.right, k, seen, last)
	seen[last] -= 1
	return result

root = Node(2, Node(3, Node(5, Node(1), Node(1, Node(3)))), Node(2, Node(4, Node(3, None, Node(5, Node(1, None, Node(3)))))))
root = Node(3, Node(5, Node(1), Node(1, Node(3))))
print(pathsWithSum(root, 9))
