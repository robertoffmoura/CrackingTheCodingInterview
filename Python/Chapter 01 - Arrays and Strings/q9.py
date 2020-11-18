def isSubstring(s1, s2):
	return s1 in s2

def stringRotation(s1, s2):
	return len(s1) == len(s2) and isSubstring(s1, s2 + s2)

print(isSubstring("abc", "aabcdef"))
print(stringRotation("abc", "bca"))
print(stringRotation("abc", "cab"))
print(stringRotation("abc", "abc"))
