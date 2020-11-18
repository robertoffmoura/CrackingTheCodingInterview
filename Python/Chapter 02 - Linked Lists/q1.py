class Node:
	def __init__(self, value, next):
		self.value = value
		self.next = next

def removeDups(node):
	seen = set()
	trav = node
	while (trav is not None):
		seen.add(trav.value)
		while (trav.next and trav.next.value in seen):
			trav.next = trav.next.next
		trav = trav.next

def removeDups2(node):
	current = node
	while (current):
		trav = current
		while (trav is not None):
			while (trav.next is not None and trav.next.value == current.value):
				trav.next = trav.next.next
			trav = trav.next
		current = current.next


def printList(node):
	trav = node
	while (trav is not None):
		print(trav.value, end=" ")
		trav = trav.next
	print("")

l = Node(1, Node(2, Node(2, Node(4, Node(5, None)))))
printList(l)
removeDups2(l)
printList(l)

l = Node(1, Node(2, Node(2, Node(4, Node(2, None)))))
printList(l)
removeDups2(l)
printList(l)

l = Node(1, Node(2, Node(2, Node(2, None))))
printList(l)
removeDups2(l)
printList(l)
