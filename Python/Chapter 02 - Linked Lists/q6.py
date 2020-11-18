class Node:
	def __init__(self, value, next):
		self.value = value
		self.next = next

	def __len__(self):
		return (1 + len(self.next)) if self.next is not None else 1

def helper(node, i):
	if (i == 0):
		return True, node
	if (i == 1):
		return True, node.next
	result, last = helper(node.next, i-2)
	if result == False:
		return False, node
	return (node.value == last.value), last.next

def palindrome(node):
	n = len(node)
	result = helper(node, n)
	return result[0]


node = Node(1, Node(2, Node(3, Node(2, Node(1, None)))))
print(palindrome(node))
node = Node(1, Node(2, Node(2, Node(1, None))))
print(palindrome(node))
node = Node(1, Node(3, Node(3, Node(2, Node(1, None)))))
print(palindrome(node))
node = Node(1, Node(3, Node(2, Node(1, None))))
print(palindrome(node))
