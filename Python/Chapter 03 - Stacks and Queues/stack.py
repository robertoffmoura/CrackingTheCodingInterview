class StackNode:
	def __init__(self, value, next):
		self.value = value
		self.next = next

class Stack:
	def __init__(self):
		self.head = None

	def pop(self):
		if self.head is None:
			print("Empty stack")
			return
		value = self.head.value
		self.head = self.head.next
		return value

	def push(self, value):
		self.head = StackNode(value, self.head)

	def peek(self):
		if self.head is None:
			print("Empty stack")
			return
		return self.head.value

	def isEmpty(self):
		return self.head is None

stack = Stack()
stack.push(1)
stack.push(2)
stack.push(3)
print(stack.peek())
print(stack.pop())
print(stack.pop())
print(stack.pop())
print(stack.pop())
