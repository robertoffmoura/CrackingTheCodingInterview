def sortedMerge(a, b):
	pointerA = len(a) - 1
	pointerB = len(b) - 1
	a += [None] * len(b)
	while (pointerA >= 0 and pointerB >= 0):
		if (a[pointerA] > b[pointerB]):
			a[pointerA + pointerB + 1] = a[pointerA]
			pointerA -= 1
		else:
			a[pointerA + pointerB + 1] = b[pointerB]
			pointerB -= 1
	while (pointerB >= 0):
		a[pointerB] = b[pointerB]
		pointerB -= 1

a = [0, 1, 2, 3, 4]
b = [1.5, 2.5, 3.5]
sortedMerge(a, b)
print(a)
