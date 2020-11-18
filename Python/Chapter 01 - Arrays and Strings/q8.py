def zeroMatrix(matrix):
	m = len(matrix)
	n = len(matrix[0])
	rowsToBeZeroed = set()
	colsToBeZeroed = set()
	for i in range(m):
		for j in range(n):
			if (matrix[i][j] == 0):
				rowsToBeZeroed.add(i)
				colsToBeZeroed.add(j)
	for i in rowsToBeZeroed:
		for j in range(n):
			matrix[i][j] = 0
	for j in colsToBeZeroed:
		for i in range(m):
			matrix[i][j] = 0

matrix = [[1,   2, 3,   4,  0,  6],
		  [7,   0, 9,  10, 11, 12],
	      [13, 15, 14, 15, 16, 17]]
print(matrix)
zeroMatrix(matrix)
print(matrix)
