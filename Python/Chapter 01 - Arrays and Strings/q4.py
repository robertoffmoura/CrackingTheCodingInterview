def getCharacterFrequency(s):
	d = {}
	for c in s:
		if (c == " "):
			continue
		c = c.lower()
		d[c] = 1 if c not in d else d[c] + 1
	return d

def palindromePermutation(s):
	frequency = getCharacterFrequency(s)
	oddFrequencyCount = 0
	for character in frequency:
		if (frequency[character] % 2 != 0):
			oddFrequencyCount += 1
			if (oddFrequencyCount > 1):
				return False
	return True

print(palindromePermutation("abab"))
print(palindromePermutation("ababc"))
print(palindromePermutation("ababcd"))
print(palindromePermutation("Taco cat"))
