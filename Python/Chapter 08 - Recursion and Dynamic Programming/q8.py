def permutations(s, result=[], current=[], remaining=None):
	if (remaining is None):
		remaining = {}
		for c in s:
			remaining[c] = (1 + remaining[c]) if c in remaining else 1
	if (len(remaining) == 0):
		result.append("".join(current))
	for c in set(remaining):
		current.append(c)
		remaining[c] -= 1
		if (remaining[c] == 0):
			del remaining[c]
		permutations(s, result, current, remaining)
		remaining[c] = (1 + remaining[c]) if c in remaining else 1
		current.pop()
	return result

print(permutations("abcc"))
# print(permutations("abbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"))
