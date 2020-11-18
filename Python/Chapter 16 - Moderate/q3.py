def cross(p1, p2):
	x1, y1 = p1
	x3, y3 = p2
	return x1*y3 - x3*y1

def clockwise(p1, p2, p3):
	return cross(p1, p2) + cross(p2, p3) + cross(p3, p1) < 0

def intersects(l1, l2):
	p1, p2 = l1
	p3, p4 = l2
	return clockwise(p1, p2, p3) != clockwise(p1, p2, p4) and clockwise(p3, p4, p1) != clockwise(p3, p4, p2)

def intersection(l1, l2):
	if not intersects(l1, l2):
		return None

	(x1, y1), (x2, y2) = l1
	(x3, y3), (x4, y4) = l2
	y = ((x3*y4 - x4*y3)*(y2 - y1) - (x2*y1 - x1*y2)*(y3 - y4)) / ((x1 - x2)*(y3 - y4) - (x4 - x3)*(y2 - y1))
	x = -((y3*x4 - y4*x3)*(x1 - x2) - (y2*x1 - y1*x2)*(x4 - x3)) / ((y1 - y2)*(x3 - x4) - (y4 - y3)*(x2 - x1))
	return x, y

l1 = [(0,0), (1,1)]
l2 = [(0,1), (1,0)]
print(intersection(l1, l2))
print(intersection(l1, l2) == (0.5, 0.5))
l1 = [(1,0), (1,2)]
l2 = [(0,1), (2,1)]
print(intersection(l1, l2))
print(intersection(l1, l2) == (1, 1))
l1 = [(0,0), (1,1)]
l2 = [(0,2), (2,0)]
print(intersection(l1, l2))
print(intersection(l1, l2) == (1, 1))
l1 = [(0,0), (1,1)]
l2 = [(0,3), (3,0)]
print(intersection(l1, l2))
print(intersection(l1, l2) is None)
l1 = [(0,0), (1,1)]
l2 = [(1,1), (2,0)]
print(intersection(l1, l2))
print(intersection(l1, l2) == (1, 1))
l1 = [(0,0), (2,0)]
l2 = [(1,0), (3,0)]
print(intersection(l1, l2))
print(intersection(l1, l2) is None)
