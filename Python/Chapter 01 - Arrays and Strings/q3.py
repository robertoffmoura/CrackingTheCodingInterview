def URLify(s):
	l = [c for c in s] + 2 * [c for c in s if c == " "]
	i = len(l) - 1
	j = i
	while (j > 0 and l[j] == " "):
		j -= 1
	while (i > 0 and j > 0):
		if (l[j] == " "):
			l[i-2], l[i-1], l[i] = "%", "2", "0"
			i -= 3
		else:
			l[i] = l[j]
			i -= 1
		j -= 1
	return "".join(l)

print(URLify("Mr John Smith"))
