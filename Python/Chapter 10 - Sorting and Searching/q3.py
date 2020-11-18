def realIndex(index, length):
	return index % length

def modifiedBinarySearch(a, k, low, high):
	if (low > high):
		return -1
	mid = (low + high)//2
	element = a[realIndex(mid, len(a))]
	if (element > k):
		return modifiedBinarySearch(a, k, low, mid-1)
	elif (element < k):
		return modifiedBinarySearch(a, k, mid+1, high)
	else:
		return mid

def searchInRotatedArray(a, k):
	breakPoint = 0
	for i in range(len(a)-1):
		if a[i] > a[i+1]:
			breakPoint = i+1
	low = breakPoint
	high = len(a) + breakPoint
	return modifiedBinarySearch(a, k, low, high)

print(searchInRotatedArray([1, 2, -2, -1, -1, 0], -2))
print(searchInRotatedArray([1, 2, -2, -1, 0, 1], 0))
