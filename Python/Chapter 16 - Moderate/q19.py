distances = [(0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1), (-1, 0), (-1, 1)]

def getNeighbors(i, j):
	return [(i+di, j+dj) for (di, dj) in distances]

def valid(i, j, plot):
	m, n = len(plot), len(plot[0])
	return 0 <= i < m and 0 <= j < n

def getSize(i, j, plot, visited):
	if (i, j) in visited or plot[i][j] > 0:
		return 0
	result = 1
	visited.add((i,j))
	for r, c in getNeighbors(i, j):
		if not valid(r, c, plot) or (r,c) in visited:
			continue
		result += getSize(r, c, plot, visited)
	return result

def pondSizes(plot):
	m, n = len(plot), len(plot[0])
	visited = set()
	sizes = set()
	for i in range(m):
		for j in range(n):
			size = getSize(i, j, plot, visited)
			if (size > 0):
				sizes.add(size)
	return list(sizes)

plot = [[0, 2, 1, 0],
		[0, 1, 0, 1],
		[1, 1, 0, 1],
		[0, 1, 0, 1]]
print(pondSizes(plot))
