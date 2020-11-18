def binarySearch(l, k, low=None, high=None):
	if low is None:
		low, high = 0, len(l)-1
	if (low > high):
		return high
	mid = (low + high)//2
	if (k < l[mid]):
		return binarySearch(l, k, low, mid-1)
	elif (k > l[mid]):
		return binarySearch(l, k, mid+1, high)
	else:
		return mid

def binarySearchRow(a, k, i):
	return binarySearch(a[i], k)

def binarySearchColumn(a, k, j):
	return binarySearch([a[i][j] for i in range(len(a))], k)

def sortedMatrixSearch(a, k):
	m, n = len(a), len(a[0])
	i, j = 0, n-1
	if (k < a[0][n-1]):
		j = binarySearchRow(a, k, 0)
	elif (k > a[0][n-1]):
		i = binarySearchColumn(a, k, n-1)
	else:
		return i, j
	while (i < n and j >= 0):
		if (k < a[i][j]):
			j -= 1
		elif (k > a[i][j]):
			i += 1
		else:
			return i, j
	return -1, -1

a = [[1, 2,  3,  4],
	 [5, 5,  6,  7],
	 [7, 8, 10, 11],
	 [9, 9, 10, 14]]
print(sortedMatrixSearch(a, 1))
print(sortedMatrixSearch(a, 5))
print(sortedMatrixSearch(a, 6))
print(sortedMatrixSearch(a, 8))
print(sortedMatrixSearch(a, 9))
print(sortedMatrixSearch(a, 14))
