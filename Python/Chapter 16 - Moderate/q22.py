directions = [(0, 1), (-1, 0), (0, -1), (1, 0)]

def turnRight(i):
	return (i+1)%len(directions)

def turnLeft(i):
	return (i-1)%len(directions)

def printKMoves(k):
	board = set()
	dir_index = 0
	minI, minJ, maxI, maxJ = 0, 0, 0, 0
	i, j = 0, 0
	for _ in range(k):
		if (i, j) not in board:
			board.add((i, j))
			dir_index = turnRight(dir_index)
		else:
			board.remove((i, j))
			dir_index = turnLeft(dir_index)
		di, dj = directions[dir_index]
		i, j = i+di, j+dj
		minI, minJ = min(minI, i), min(minJ, j)
		maxI, maxJ = max(maxI, i), max(maxJ, j)
	print("")
	for i in range(minI, maxI+1):
		for j in range(minJ, maxJ+1):
			print("1" if (i, j) in board else "0", end="")
		print("")
	print("")

current = 0
while (True):
	k = input()
	printKMoves(current)
	current += 1
