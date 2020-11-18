class Node:
	def __init__(self, value, next):
		self.value = value
		self.next = next

def partition(node, x):
	right = None
	head = Node(None, node)
	trav = node
	previous = head
	while (trav is not None):
		if (trav.value >= x):
			previous.next = trav.next
			trav.next = right
			right = trav
			trav = previous.next
		else:
			previous = trav
			trav = trav.next
	previous.next = right
	return head.next

def printLinkedList(ndoe):
	trav = node
	while (trav is not None):
		print(trav.value, end=" ")
		trav = trav.next
	print("")


node = Node(1, Node(7, Node(3, Node(8, Node(9, Node(0, Node(5, None)))))))
printLinkedList(node)
node = partition(node, 5)
printLinkedList(node)

node = Node(10, Node(7, Node(3, Node(8, Node(9, Node(0, Node(5, None)))))))
printLinkedList(node)
node = partition(node, 5)
printLinkedList(node)
