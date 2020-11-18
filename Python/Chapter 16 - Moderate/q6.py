def smallestDifference(l1, l2):
	if (l1 is None or l2 is None or len(l1) == 0 or len(l2) == 0):
		return None
	l1, l2 = sorted(l1), sorted(l2)
	bestDiff, bestElements = abs(l1[0] - l2[0]), (l1[0], l2[0])
	i2 = 0
	for i1 in range(len(l1)):
		while (i2 < len(l2) and (l2[i2] <= l1[i1] or (i2 > 0 and l2[i2-1] <= l1[i1]))):
			diff = abs(l1[i1] - l2[i2])
			if (diff < bestDiff):
				bestDiff = diff
				bestElements = l1[i1], l2[i2]
			i2 += 1
	return bestDiff, bestElements

l1 = [1, 3, 15, 11, 2]
l2 = [23, 127, 235, 19, 8]
print(smallestDifference(l1, l2))
