from collections import deque
import time

def countParens(n, openCount=0, closedCount=0):
	if (closedCount > openCount or openCount > n):
		return 0
	if (closedCount == n):
		return 1
	return countParens(n, openCount+1, closedCount) + countParens(n, openCount, closedCount+1)

print(countParens(3))

def parens(n, result=[], current=[], openCount=0, closedCount=0):
	if (closedCount > openCount or openCount > n):
		return
	if (closedCount == n):
		result.append("".join(current))
		return
	current.append('(')
	open = parens(n, result, current, openCount+1, closedCount)
	current.pop()
	current.append(')')
	close = parens(n, result, current, openCount, closedCount+1)
	current.pop()
	return result

start_time = time.time()
parens(13)
print("elapsed time: " + str(time.time() - start_time))

# def parens2(n, openCount=0, closedCount=0, memo={}):
# 	if (closedCount > openCount or openCount > n):
# 		return []
# 	if (closedCount == n):
# 		return [[]]
# 	if ((openCount-n, closedCount-n) in memo):
# 		return memo[(openCount-n, closedCount-n)]
#
# 	result = []
# 	open = parens2(n, openCount+1, closedCount)
# 	for solution in open:
# 		result.append(['('] + solution)
# 	close = parens2(n, openCount, closedCount+1)
# 	for solution in close:
# 		result.append([')'] + solution)
#
# 	memo[(openCount-n, closedCount-n)] = result
# 	if (openCount == 0 and closedCount == 0):
# 		return ["".join(list(q)) for q in result]
# 	return result

start_time = time.time()
parens2(13)
print("elapsed time: " + str(time.time() - start_time))
