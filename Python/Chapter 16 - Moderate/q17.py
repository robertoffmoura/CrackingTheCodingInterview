def cumulative(l):
	result = []
	current = 0
	for i in range(len(l)):
		current += l[i]
		result.append(current)
	return result

def largestContiguousSequenceSum(l):
	c = cumulative(l)
	minLeft = 0
	maxSum = 0
	n = len(c)
	for i in range(n):
		minLeft = min(minLeft, c[i])
		maxSum = max(maxSum, c[i] - minLeft)
	return maxSum

l = [2, -8, 3, -2, 4, -10]
print(largestContiguousSequenceSum(l))
