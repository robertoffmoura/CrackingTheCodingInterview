def sortStack(stack):
	helperStack = []
	helperStackStart = 0

	def extractBiggest():
		biggest = float("-inf")
		count = 0
		while (len(stack) > 0):
			current = stack.pop()
			if (current > biggest):
				biggest = current
				count = 1
			elif (current == biggest):
				count += 1
			helperStack.append(current)
		while (len(helperStack) > helperStackStart):
			current = helperStack.pop()
			if (current == biggest):
				continue
			stack.append(current)
		return biggest, count

	while (len(stack) > 0):
		biggest, count = extractBiggest()
		for i in range(count):
			helperStack.append(biggest)
		helperStackStart += count

	while (len(helperStack) > 0):
		stack.append(helperStack.pop())

stack = [1, 2, 8, 7, 9, 3, 2, 1, 2, 5]
sortStack(stack)
print(stack)
