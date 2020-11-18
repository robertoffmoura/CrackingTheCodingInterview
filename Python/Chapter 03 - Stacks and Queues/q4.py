class QueueFromTwoStacks:
	def __init__(self):
		self.leftStack = []
		self.rightStack = []

	def add(self, value):
		self.leftStack.append(value)

	def remove(self):
		if (len(self.rightStack) == 0):
			self.shiftLeftToRight()
		if (len(self.rightStack) == 0):
			print("Empty queue")
			return
		return self.rightStack.pop()

	def shiftLeftToRight(self):
		while (len(self.leftStack) > 0):
			self.rightStack.append(self.leftStack.pop())

queue = QueueFromTwoStacks()
queue.add(1)
queue.add(2)
queue.add(3)
print(queue.remove())
queue.add(4)
queue.add(5)
queue.add(6)
print(queue.remove())
print(queue.remove())
print(queue.remove())
print(queue.remove())
print(queue.remove())
print(queue.remove())
