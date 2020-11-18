class Node:
	def __init__(self, value, next):
		self.value = value
		self.next = next

def deleteMiddleNode(node):
	node.value = node.next.value
	node.next = node.next.next

def printLinkedList(head):
	trav = head
	while (trav):
		print(trav.value, end=" ")
		trav = trav.next
	print("")

node = Node(4, Node(5, Node(6, Node(7, None))))
head = Node(1, Node(2, Node(3, node)))

printLinkedList(head)
deleteMiddleNode(node)
printLinkedList(head)
