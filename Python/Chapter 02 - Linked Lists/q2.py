class Node:
	def __init__(self, value, next):
		self.value = value
		self.next = next

	def __len__(self):
		trav = self
		result = 0
		while (trav is not None):
			result += 1
			trav = trav.next
		return result
		# return 1 + (len(self.next) if self.next else 0)

def kth(node, k):
	trav = node
	i = 0
	while (i < k-1 and trav):
		trav = trav.next
		i += 1
	return trav

def kthToLast(node, k):
	n = len(node)
	return kth(node, n-k)

node = Node(1, Node(2, Node(3, Node(4, Node(5, None)))))
print(kthToLast(node, 0).value)
print(kthToLast(node, 1).value)
print(kthToLast(node, 2).value)

def helper(node, k):
	if (node.next is None):
		return node, 0
	helper_node, position = helper(node.next, k)
	if (position == k):
		return helper_node, position
	return node, position + 1

def kthToLast2(node, k):
	return helper(node, k)[0]

print(kthToLast2(node, 0).value)
print(kthToLast2(node, 1).value)
print(kthToLast2(node, 2).value)
