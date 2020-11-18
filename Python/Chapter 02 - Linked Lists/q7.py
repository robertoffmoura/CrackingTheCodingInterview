class Node:
	def __init__(self, value, next):
		self.value = value
		self.next = next

	def __len__(self):
		result = 1
		trav = self
		while (trav is not None):
			result += 1
			trav = trav.next
		return result

def inserction(l1, l2):
	n1 = len(l1)
	n2 = len(l2)
	n = max(n1, n2)
	trav1, trav2 = l1, l2
	for i in range(n-n2):
		trav1 = trav1.next
	for i in range(n-n1):
		trav2 = trav2.next
	while (trav1 is not None and trav2 is not None):
		if (trav1 == trav2):
			return trav1
		trav1 = trav1.next
		trav2 = trav2.next
	return None

intersect = Node(1, Node(2, Node(3, Node(4, None))))
l1 = Node(2, Node(3, Node(4, intersect)))
l2 = Node(4, intersect)
print(inserction(l1, l2).value)
