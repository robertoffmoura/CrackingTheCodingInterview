class QueueNode:
	def __init__(self, value, next):
		self.value = value
		self.next = next

class Queue:
	def __init__(self):
		self.head = None
		self.tail = None

	def popleft(self):
		if self.head is None:
			print("Empty queue")
			return
		value = self.head.value
		self.head = self.head.next
		if self.head is None:
			self.tail = None
		return value

	def push(self, value):
		if self.tail is None:
			self.tail = QueueNode(value, None)
			self.head = self.tail
			return
		self.tail.next = QueueNode(value, None)
		self.tail = self.tail.next

	def peek(self):
		if self.head is None:
			print("Empty queue")
			return
		return self.head.value

	def isEmpty(self):
		return self.head is not None

queue = Queue()
queue.push(1)
queue.push(2)
queue.push(3)
print(queue.peek())
print(queue.popleft())
print(queue.popleft())
print(queue.popleft())
