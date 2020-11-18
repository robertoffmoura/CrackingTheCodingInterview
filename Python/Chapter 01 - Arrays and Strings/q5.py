def atMost1Replace(s1, s2):
	# s1 is s2 with at most one replacement
	replaces = 0
	for i in range(len(s1)):
		if s1[i] != s2[i]:
			replaces += 1
			if (replaces > 1):
				return False
	return True

def atMost1Insertion(s1, s2):
	# s1 is s2 with at most one insertion
	i, j = 0, 0
	insertions = 0
	while (j < len(s2)):
		if (s1[i] != s2[j]):
			insertions += 1
			if (insertions > 1):
				return False
		else:
			j += 1
		i += 1
	return True

def oneAway(s1, s2):
	if len(s1) == len(s2):
		return atMost1Replace(s1, s2)
	if (len(s2) > len(s1)):
		s1, s2 = s2, s1
	if (len(s1) == len(s2) + 1):
		return atMost1Insertion(s1, s2)
	return False

print(oneAway("pale", "ple"))
print(oneAway("pales", "pale"))
print(oneAway("pale", "bale"))
print(oneAway("pale", "bake"))
