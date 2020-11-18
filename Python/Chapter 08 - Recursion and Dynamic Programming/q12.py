def conflict(current, i):
	c_new, r_new = len(current), i
	for c, r in enumerate(current):
		if (c == c_new or r == r_new):
			return True
		if (c-r == c_new-r_new or c+r == c_new+r_new):
			return True
	return False

def eightQueens(result=[], current=[], index=0):
	if (index == 8):
		result.append(current.copy())
		return
	for i in range(8):
		if conflict(current, i):
			continue
		current.append(i)
		eightQueens(result, current, index+1)
		current.pop()
	return result

def boardFromIndices(solution):
	board = [[0 for j in range(8)] for i in range(8)]
	for c, r in enumerate(solution):
		board[c][r] = 1
	return board

def printBoard(board):
	for i in range(8):
		for j in range(8):
			print(str(board[i][j]), end=" ")
		print("")

solutions = eightQueens()
for solution in solutions:
	printBoard(boardFromIndices(solution))
	print("")
print(len(solutions))
