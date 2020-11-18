def countCharacters(s):
	d = {}
	for c in s:
		d[c] = 1 if c not in d else d[c] + 1
	return d

def checkPermutation(s1, s2):
	frequencies1 = countCharacters(s1)
	frequencies2 = countCharacters(s2)
	if (len(frequencies1) != len(frequencies2)):
		return False
	for character in frequencies1:
		if character not in frequencies2 or frequencies1[character] != frequencies2[character]:
			return False
	return True
