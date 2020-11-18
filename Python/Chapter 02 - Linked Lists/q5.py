class Node:
	def __init__(self, value, next):
		self.value = value
		self.next = next

	def __len__(self):
		return (1 + len(self.next)) if self.next is not None else 1

def sumLists(l1, l2):
	head = Node(None, None)
	current = head
	trav1, trav2 = l1, l2
	carry = 0
	previous = None
	while (trav1 is not None or trav2 is not None):
		value = carry
		if (trav1 is not None):
			value += trav1.value
		if (trav2 is not None):
			value += trav2.value
		carry = value//10
		value = value%10
		current.value = value
		current.next = Node(None, None)
		previous = current
		current = current.next
		if (trav1 is not None):
			trav1 = trav1.next
		if (trav2 is not None):
			trav2 = trav2.next
	if carry > 0:
		current.value = carry
	else:
		previous.next = None
	return head

def helper(node1, node2, result):
	if (node1 is None or node2 is None):
		return
	result.next = Node(None, None)
	helper(node1.next, node2.next, result.next)
	carry = 0
	if result.next.value is None:
		result.next = None
	else:
		carry = result.next.value//10
		result.next.value %= 10
	result.value = node1.value + node2.value + carry

def addZeroPadding(l, n):
	for i in range(n):
		node = Node(0, l)
		l = node
	return l


def recursivelySumLists(l1, l2):
	n1 = len(l1)
	n2 = len(l2)
	n = max(n1, n2)
	l1, l2 = addZeroPadding(l1, n-n1), addZeroPadding(l2, n-n2)
	result = Node(None, None)
	helper(l1, l2, result)
	if result.value > 9:
		head = Node(result.value//10, result)
		result.value %= 10
		result = head
	return result



def printLinkedList(node):
	trav = node
	while (trav is not None):
		print(trav.value, end=" ")
		trav = trav.next
	print("")

l1 = Node(1, Node(3, Node(9, Node(0, Node(9, Node(9, Node(1, None)))))))
l2 = Node(1, Node(4, Node(5, Node(0, Node(0, Node(2, None))))))
l3 = sumLists(l1, l2)
printLinkedList(l1)
printLinkedList(l2)
printLinkedList(l3)
print("")

l1 = Node(1, Node(9, Node(9, Node(0, Node(9, Node(3, Node(1, None)))))))
l2 = Node(2, Node(0, Node(0, Node(5, Node(4, Node(1, None))))))
l3 = recursivelySumLists(l1, l2)
printLinkedList(l1)
printLinkedList(l2)
printLinkedList(l3)
