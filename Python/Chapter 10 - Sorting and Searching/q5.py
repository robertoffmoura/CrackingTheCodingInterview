def getClosestNonNullItem(l, index, upwards):
	if upwards:
		i = index
		while (i < len(l)):
			if (l[i] != ""):
				return i
			i += 1
		return i
	else:
		i = index
		while (i >= 0):
			if (l[i] != ""):
				return i
			i -= 1
		return i

def sparseSearch(l, s, low=None, high=None, upwards=True):
	if (high is None):
		low, high = 0, len(l)
	if (low > high):
		return -1
	mid = (low + high)//2
	mid = getClosestNonNullItem(l, mid, upwards)
	if (mid > high or mid < low):
		return -1

	if (l[mid] < s):
		return sparseSearch(l, s, mid+1, high, True)
	elif (l[mid] > s):
		return sparseSearch(l, s, low, mid-1, False)
	else:
		return mid

l = ["at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""]
print(sparseSearch(l, "at"))
print(sparseSearch(l, "ball"))
print(sparseSearch(l, "car"))
print(sparseSearch(l, "dad"))
