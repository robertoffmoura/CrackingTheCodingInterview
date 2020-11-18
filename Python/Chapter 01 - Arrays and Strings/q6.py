def compress(s):
	l = []
	i = 0
	currentCount = 1
	while (i < len(s)):
		while (i < len(s) - 1 and s[i] == s[i+1]):
			currentCount += 1
			i += 1
		l.append(s[i])
		l.append(str(currentCount))
		currentCount = 1
		i += 1
	result = "".join(l)
	return result if len(result) < len(s) else s

print(compress("aabcccccaaa"))
