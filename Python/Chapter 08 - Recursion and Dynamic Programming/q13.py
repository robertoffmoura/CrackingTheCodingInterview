def fits(last, box, h, w, d):
	return h[last] > h[box] and w[last] > w[box] and d[last] > d[box]

def tallestStack(h, w, d, result=[[],0], current=[], remaining=None, height=[0]):
	n = len(h)
	if remaining is None:
		remaining = {i for i in range(n)}
	if height[0] > result[1]:
		result[0] = current.copy()
		result[1] = height[0]
	largerBoxes = set()
	for box in set(remaining):
		if (len(current) > 0):
			last = current[-1]
			if not fits(last, box, h, w, d):
				remaining.remove(box)
				largerBoxes.add(box)
				continue
		remaining.remove(box)
		current.append(box)
		height[0] += h[box]
		tallestStack(h, w, d, result, current, remaining, height)
		height[0] -= h[box]
		current.remove(box)
		remaining.add(box)
	remaining = remaining.update(largerBoxes)
	return result

# def tallestStackHeight(h, w, d, result=[0], remaining=None, height=[0], last=None):
# 	n = len(h)
# 	if remaining is None:
# 		remaining = {i for i in range(n)}
# 	largerBoxes = set()
# 	for box in set(remaining):
# 		if (last is not None):
# 			if not fits(last, box, h, w, d):
# 				remaining.remove(box)
# 				largerBoxes.add(box)
# 				continue
# 		remaining.remove(box)
# 		height[0] += h[box]
# 		tallestStackHeight(h, w, d, result, remaining, height, box)
# 		height[0] -= h[box]
# 		remaining.add(box)
# 	remaining = remaining.update(largerBoxes)
# 	if height[0] > result[0]:
# 		result[0] = height[0]
# 	return result

# def tallestStackHeight(h, w, d, remaining=None, last=None):
# 	n = len(h)
# 	if remaining is None:
# 		remaining = {i for i in range(n)}
# 	largerBoxes = set()
# 	bestHeight = 0
# 	for box in set(remaining):
# 		if (last is not None):
# 			if not fits(last, box, h, w, d):
# 				remaining.remove(box)
# 				largerBoxes.add(box)
# 				continue
# 		remaining.remove(box)
# 		height = h[box] + tallestStackHeight(h, w, d, remaining, box)
# 		remaining.add(box)
# 		bestHeight = max(bestHeight, height)
# 	remaining = remaining.update(largerBoxes)
# 	return bestHeight

def tallestStackHeight(h, w, d, remaining=None, last=None, memo={}):
	n = len(h)
	if remaining is None:
		remaining = {i for i in range(n)}
	if last in memo:
		return memo[last]
	largerBoxes = set()
	bestHeight = 0
	for box in set(remaining):
		if (last is not None):
			if not fits(last, box, h, w, d):
				remaining.remove(box)
				largerBoxes.add(box)
				continue
		remaining.remove(box)
		height = h[box] + tallestStackHeight(h, w, d, remaining, box, memo)
		remaining.add(box)
		bestHeight = max(bestHeight, height)
	remaining = remaining.update(largerBoxes)
	memo[last] = bestHeight
	return bestHeight

h = [2, 3, 4, 1, 1]
w = [2, 3, 5, 5, 2]
d = [2, 3, 5, 7, 2]
print(tallestStack(h, w, d))
print(tallestStackHeight(h, w, d))
