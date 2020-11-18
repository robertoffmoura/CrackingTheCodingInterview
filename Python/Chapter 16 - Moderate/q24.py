def pairsWithSum(l, k):
	result = set()
	seen = set()
	for element in l:
		dual = k - element
		if (dual in seen):
			small, big = min(element, dual), max(element, dual)
			result.add((small, big))
		seen.add(element)
	return list(result)

l = [5, 6, 5, 4, 7]
k = 11
print(pairsWithSum(l, k))
