class Node:
	def __init__(self, value):
		self.value = value
		self.left = None
		self.right = None

def minimalTree(l, start=None, end=None):
	if (start is None or end is None):
		return minimalTree(l, 0, len(l)-1)
	if (start > end):
		return None
	mid = (start+end)//2
	node = Node(l[mid])
	node.left = minimalTree(l, start, mid-1)
	node.right = minimalTree(l, mid+1, end)
	return node

def printTree(node, depth=0):
	if (node is None):
		print("  " * depth + "None")
		return
	printTree(node.right, depth+1)
	print("  " * depth + str(node.value))
	printTree(node.left, depth+1)

printTree(minimalTree([1,2,3,4,5,6,7]))
