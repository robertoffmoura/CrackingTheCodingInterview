class MinStack:
	def __init__(self):
		self.stack = []
		self.minima = []

	def push(self, value):
		self.stack.append(value)
		if (len(self.minima) == 0 or value <= self.minima[-1]):
			self.minima.append(value)

	def pop(self):
		if (len(self.stack) == 0):
			print("Empty minStack")
			return
		value = self.stack.pop()
		if (value == self.minima[-1]):
			self.minima.pop()
		return value

	def min(self):
		if (len(self.minima) == 0):
			print("Empty minStack")
		return self.minima[-1]

minStack = MinStack()
minStack.push(3)
print(minStack.min())
minStack.push(1)
print(minStack.min())
minStack.push(4)
print(minStack.min())
minStack.push(5)
print(minStack.min())
print(minStack.pop())
print(minStack.min())
print(minStack.pop())
print(minStack.min())
print(minStack.pop())
print(minStack.min())
