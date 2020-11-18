def divingBoard(shorter, longer, k):
	current = k * shorter
	result = [current]
	for i in range(k):
		current += longer - shorter
		result.append(current)
	return result

def divingBoard2(shorter, longer, k):
	return [(k-i)*shorter + i*longer for i in range(k+1)]

print(divingBoard(1, 3, 2))
print(divingBoard2(1, 3, 2))
