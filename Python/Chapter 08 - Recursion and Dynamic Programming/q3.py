def magicIndex(A):
	B = [A[i] - i for i in range(len(A))]
	return binarySearch(B, 0)

def magicIndex2(A):
	i = 0
	n = len(A)
	while (i < n):
		if A[i] == i:
			return i
		if A[i] > i:
			i = A[i]
		else:
			i += 1
	return None
