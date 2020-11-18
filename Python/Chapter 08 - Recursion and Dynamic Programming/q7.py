def permutations(s, result=[], current=[], remaining=None):
	if (remaining is None):
		remaining = set([c for c in s])
	if (len(remaining) == 0):
		result.append("".join(current))
	for c in set(remaining):
		current.append(c)
		remaining.remove(c)
		permutations(s, result, current, remaining)
		remaining.add(c)
		current.pop()
	return result

print(permutations("abc"))
