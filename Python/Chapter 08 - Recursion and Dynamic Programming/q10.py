neighbor_directions_i = [0, 1, 0, -1]
neighbor_directions_j = [1, 0, -1, 0]

def neighbors(i, j):
	return [(i + neighbor_directions_i[k], j + neighbor_directions_j[k]) for k in range(len(neighbor_directions_i))]

def valid(i, j, image):
	n, m = len(image), len(image[0])
	return 0 <= i < n and 0 <= j < m

def paintFill(image, color, i, j, firstColor=None):
	if firstColor is None:
		firstColor = image[i][j]
	if image[i][j] != firstColor:
		return
	image[i][j] = color
	for r, c in neighbors(i, j):
		if not valid(r, c, image):
			continue
		paintFill(image, color, r, c, firstColor)

image = [[1, 2, 2, 1],
		 [2, 1, 2, 3],
		 [3, 3, 1, 2]]
print(image)
paintFill(image, 3, 0, 1)
print(image)
