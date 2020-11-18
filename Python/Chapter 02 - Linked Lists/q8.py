class Node:
	def __init__(self, value, next):
		self.value = value
		self.next = next

def getStartOfLoop(node):
	fast = node
	slow = node
	while (slow is not None and fast is not None and fast.next is not None):
		slow = slow.next
		fast = fast.next.next
		if (slow == fast):
			break
	if (slow != fast):
		return None
	third = node
	while (third != slow):
		third = third.next
		slow = slow.next
	return third

loop = Node(4, Node(5, Node(6, Node(7, None))))
loop.next.next.next.next = loop
head = Node(1, Node(2, Node(3, loop)))

linear = Node(1, Node(2, Node(3, Node(4, None))))

print(getStartOfLoop(head).value)
print(getStartOfLoop(linear))
