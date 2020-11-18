def yearWithMostNumberOfPeopleAlive(l):
	start, end = 1900, 2000
	sizeOfArray = (end - start + 2)
	n = len(l)
	change = [0] * sizeOfArray
	for i in range(len(l)):
		name, birth, death = l[i]
		change[birth - start] += 1
		change[death - start + 1] -= 1
	maxi, bestYear = 0, start
	current = 0
	for i in range(sizeOfArray):
		current += change[i]
		if (current > maxi):
			maxi = current
			bestYear = start + i
	return bestYear

people = [("a", 1900, 1951), ("b", 1950, 1990), ("c", 1995, 1998)]
print(yearWithMostNumberOfPeopleAlive(people))
