def rotateMatrix(m):
	n = len(m)
	for i in range(n//2):
		for j in range((n+1)//2):
			temp = m[i][j]
			m[i][j] = m[n-1-j][i]
			m[n-1-j][i] = m[n-1-i][n-1-j]
			m[n-1-i][n-1-j] = m[j][n-1-i]
			m[j][n-1-i] = temp

a = [[1, 2],
	 [3, 4]]
print(a)
rotateMatrix(a)
print(a)
