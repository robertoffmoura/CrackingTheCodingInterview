from collections import deque

class Node:
	def __init__(self, value):
		self.value = value
		self.neighbors = []

def routeBetweenTwoNodes(a, b):
	queueA = deque([a])
	queueB = deque([b])
	seenA = set()
	seenB = set()
	while (len(queueA) > 0 or len(queueB) > 0):
		if (len(queueA) > 0):
			currentA = queueA.popleft()
			if currentA == b:
				return True
			for neighbor in currentA.neighbors:
				if neighbor not in seenA:
					queueA.append(neighbor)
					seenA.add(neighbor)
		if (len(queueB) > 0):
			currentB = queueB.popleft()
			if currentB == a:
				return True
			for neighbor in currentB.neighbors:
				if neighbor not in seenB:
					queueB.append(neighbor)
					seenB.add(neighbor)
	return False

a = Node("a")
b = Node("b")
c = Node("c")
d = Node("d")
e = Node("e")
a.neighbors.append(b)
b.neighbors.append(d)
c.neighbors.append(b)
d.neighbors.append(e)
e.neighbors = [d, c]
print(routeBetweenTwoNodes(a, e))
