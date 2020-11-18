class SetOfStacks:
	def __init__(self):
		self.stacks = []
		self.individualStackCapacity = 3

	def push(self, value):
		if (len(self.stacks) == 0):
			self.stacks.append([])
		lastStack = self.stacks[-1]
		if (len(lastStack) == self.individualStackCapacity):
			newStack = [value]
			self.stacks.append(newStack)
		else:
			lastStack.append(value)

	def pop(self):
		if (len(self.stacks) == 0):
			print("Empty set of stacks")
			return
		lastStack = self.stacks[-1]
		value = lastStack.pop()
		if (len(lastStack) == 0):
			self.stacks.pop()
		return value

setOfStacks = SetOfStacks()
setOfStacks.push(1)
setOfStacks.push(2)
setOfStacks.push(3)
setOfStacks.push(4)
setOfStacks.push(5)
setOfStacks.push(6)
setOfStacks.push(7)
print(setOfStacks.pop())
print(setOfStacks.pop())
print(setOfStacks.pop())
print(setOfStacks.pop())
print(setOfStacks.pop())
print(setOfStacks.pop())
print(setOfStacks.pop())
print(setOfStacks.pop())

class SetOfStacks2:
	def __init__(self):
		self.stacks = []
		self.individualStackCapacity = 3

	def push(self, value):
		if (len(self.stacks) == 0):
			self.stacks.append([])
		lastStack = self.stacks[-1]
		if (len(lastStack) == self.individualStackCapacity):
			newStack = [value]
			self.stacks.append(newStack)
		else:
			lastStack.append(value)

	def pop(self):
		while (len(self.stacks) > 0 and len(self.stacks[-1]) == 0):
			self.stacks.pop()
		if (len(self.stacks) == 0):
			print("Empty set of stacks")
			return
		return self.stacks[-1].pop()

	def popAt(self, index):
		if not (0 <= index < len(self.stacks)):
			print("Invalid index")
			return
		stack = self.stacks[index]
		if (len(stack) == 0):
			print("Empty stack at specified index")
			return
		return stack.pop()

setOfStacks = SetOfStacks2()
setOfStacks.push(1)
setOfStacks.push(2)
setOfStacks.push(3)
setOfStacks.push(4)
setOfStacks.push(5)
setOfStacks.push(6)
setOfStacks.push(7)
print(setOfStacks.popAt(0))
print(setOfStacks.pop())
print(setOfStacks.pop())
print(setOfStacks.pop())
print(setOfStacks.pop())
print(setOfStacks.pop())
print(setOfStacks.pop())
print(setOfStacks.pop())
