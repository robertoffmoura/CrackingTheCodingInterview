def binarySearchFirstOccurenceOf(listy, element, low, high):
	if (low > high):
		return high if listy[high] == element else low
	mid = (low + high)//2
	if (listy[mid] != element):
		return binarySearchFirstOccurenceOf(listy, element, mid+1, high)
	else:
		return binarySearchFirstOccurenceOf(listy, element, low, mid-1)

def binarySearch(listy, k, low, high):
	if (low > high):
		return -1
	mid = (low + high)//2
	if (listy[mid] > k):
		return binarySearch(listy, k, low, mid-1)
	elif (listy[mid] < k):
		return binarySearch(listy, k, mid+1, high)
	else:
		return mid


def sortedSearchNoSize(listy, k):
	if (listy[0] == k):
		return 0
	index = 1
	while (True):
		if (listy[index] == -1):
			break
		elif (listy[index] < k):
			index *= 2
		elif (listy[index] > k):
			break
		else:
			return index
	low = index // 2
	high = index
	if (listy[index] == -1):
		high = binarySearchFirstOccurenceOf(listy, -1, low, high) - 1
	return binarySearch(listy, k, low, high)

l = [1, 3, 5, 7, 10, 14, 20, 280, 310]
l += [-1] * len(l)
print(sortedSearchNoSize(l, 10))
print(sortedSearchNoSize(l, 11))
print(sortedSearchNoSize(l, 14))
print(sortedSearchNoSize(l, 15))
print(sortedSearchNoSize(l, 20))
print(sortedSearchNoSize(l, 280))
print(sortedSearchNoSize(l, 281))
print(sortedSearchNoSize(l, 310))
print(sortedSearchNoSize(l, 311))
