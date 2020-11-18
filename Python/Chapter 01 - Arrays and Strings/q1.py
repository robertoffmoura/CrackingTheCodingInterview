def isUnique(s):
	seen = set()
	for c in s:
		if c in seen:
			return False
		seen.add(c)
	return True

def isUnique2(s):
	return len(set(s)) == len(s)

def isUnique3(s):
	for i in range(len(s)):
		for j in range(i+1, len(s)):
			if (s[i] == s[j]):
				return False
	return True

def isUnique4(s):
	s = sorted(s)
	for i in range(len(s) - 1):
		if (s[i] == s[i+1]):
			return False
	return True
