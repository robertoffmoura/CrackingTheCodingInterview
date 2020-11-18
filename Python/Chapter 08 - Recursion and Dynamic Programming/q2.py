def robotInAGrid(r, c, obstacles):
	visitedCells = set()
	def valid(i, j):
		return 0 <= i < r and 0 <= j < c

	def helper(i, j):
		if not valid(i, j) or (i, j) in obstacles or (i, j) in visitedCells:
			return False
		visitedCells.add((i, j))
		if (i == r-1 and j == c-1):
			return True
		right = helper(i, j+1)
		down = helper(i+1, j)
		return down or right
	return helper(0, 0)

r = 10
c = 10
# obstacles = {(9,8), (8,9)}
obstacles = {}
print(robotInAGrid(r, c, obstacles))
