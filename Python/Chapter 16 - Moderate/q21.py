def sumSwap(l1, l2):
	diff = sum(l1) - sum(l2)
	s1, s2 = set(l1), set(l2)
	for element in s2:
		searched = element + diff/2
		if searched in s1:
			return element, searched

print(sumSwap([4, 1, 2, 1, 1, 2], [3, 6, 3, 3]))
