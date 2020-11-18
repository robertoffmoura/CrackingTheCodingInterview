# def tripleStep(n, memo={}):
# 	if (n < 0):
# 		return 0
# 	if (n == 0):
# 		return 1
# 	if n in memo:
# 		return memo[n]
# 	memo[n] = tripleStep(n-3, memo) + tripleStep(n-2, memo) + tripleStep(n-1, memo)
# 	return memo[n]

def tripleStep(n):
	threeStepsBehind = 0
	twoStepsBehind   = 0
	oneStepBehind    = 1
	for i in range(n):
		temp = oneStepBehind + twoStepsBehind + threeStepsBehind
		threeStepsBehind = twoStepsBehind
		twoStepsBehind = oneStepBehind
		oneStepBehind = temp
	return oneStepBehind

def kStep(n, k):
	stepsBehind = [0] * k
	stepsBehind[0] = 1
	for i in range(n):
		temp = sum(stepsBehind)
		for j in range(k-1, 0, -1):
			stepsBehind[j] = stepsBehind[j-1]
		stepsBehind[0] = temp
	return stepsBehind[0]


print(tripleStep(200))
print(kStep(200, 3))
