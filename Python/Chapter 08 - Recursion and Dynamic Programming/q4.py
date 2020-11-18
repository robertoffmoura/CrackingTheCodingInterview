# def powerSet(l, current=[], i=0):
# 	if (i == len(l)):
# 		return [current.copy()]
# 	excluding = powerSet(l, current, i+1)
# 	current.append(l[i])
# 	including = powerSet(l, current, i+1)
# 	current.pop()
# 	excluding.extend(including)
# 	return excluding

# def powerSet(l, current=[], i=0):
# 	if (i == len(l)):
# 		return [current]
# 	excluding = powerSet(l, current, i+1)
# 	including = powerSet(l, current + [l[i]], i+1)
# 	excluding.extend(including)
# 	return excluding

# def powerSet(l):
# 	result = []
# 	current = []
# 	def helper(result, current, i=0):
# 		if (i == len(l)):
# 			result.append(current.copy())
# 			return
# 		helper(result, current, i+1)
# 		current.append(l[i])
# 		helper(result, current, i+1)
# 		current.pop()
# 	helper(result, current)
# 	return result

def powerSet(l, result=[], current=[], i=0):
	if (i == len(l)):
		result.append(current.copy())
		return
	powerSet(l, result, current, i+1)
	current.append(l[i])
	powerSet(l, result, current, i+1)
	current.pop()
	return result

print(powerSet([1, 2, 3, 4]))
