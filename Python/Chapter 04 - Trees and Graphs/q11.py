from collections import deque
import random
import time

class Node:
	def __init__(self, value, left=None, right=None):
		self.value = value
		self.left = left
		self.right = right

def randomNode(root):
	chosen = root.value
	count = 0
	queue = deque()
	queue.append(root)
	while (len(queue) > 0):
		current = queue.popleft()
		r = random.random()
		if r < 1/(count+1):
			chosen = current.value
		count += 1
		if (current.left):
			queue.append(current.left)
		if (current.right):
			queue.append(current.right)
	return chosen

n = 1000000

start_time = time.time()
root = Node(4, Node(2, Node(1), Node(3)), Node(5))
count = {}
for i in range(n):
	r = randomNode(root)
	count[r] = (1 + count[r]) if r in count else 1
print(count)
print("elapsed time: " + str(time.time() - start_time))

# class NodeOfRandomTree:
# 	def __init__(self, value, left=None, right=None):
# 		self.value = value
# 		self.left = left
# 		self.right = right

class RandomTree:
	def __init__(self):
		self.nodes = []
		self.nodeSizes = []

	def insert(self, value):
		self.nodes.append(value)
		self.nodeSizes.append(0)
		index = len(self.nodes) - 1
		while (index >= 0):
			self.nodeSizes[index] += 1
			index = self.parent(index)

	def delete(self, value):
		index = self.find(value)
		if index is None:
			return
		self.nodes[index] = None
		while (index >= 0):
			self.nodeSizes[index] -= 1
			index = self.parent(index)

	def leftChild(self, index):
		return 2*index + 1

	def rightChild(self, index):
		return 2*index  + 2

	def parent(self, index):
		return (index - 1)//2

	def validIndex(self, index):
		n = len(self.nodes)
		return 0 <= index < n and self.nodes[index] is not None

	def find(self, value):
		index = 0
		queue = deque()
		queue.append(index)
		while (len(queue) > 0):
			currentIndex = queue.popleft()
			if self.nodes[currentIndex] == value:
				return currentIndex
			left, right = self.leftChild(currentIndex), self.rightChild(currentIndex)
			if self.validIndex(left):
				queue.append(left)
			if self.validIndex(right):
				queue.append(right)
		return None


	def getRandomNode(self):
		root = 0
		size = self.nodeSizes[root]
		r = int(random.random() * size)
		index = root
		while True:
			left = self.leftChild(index)
			if self.validIndex(left):
				leftSize = self.nodeSizes[left]
				if r < leftSize:
					index = left
					continue
				r -= leftSize
			if (r == 0):
				return self.nodes[index]
			right = self.rightChild(index)
			index = right
			r -= 1

randomTree = RandomTree()
randomTree.insert(1)
randomTree.insert(2)
randomTree.insert(3)
randomTree.insert(4)
randomTree.insert(5)
randomTree.insert(6)
randomTree.delete(6)

start_time = time.time()
count = {}
for i in range(n):
	r = randomTree.getRandomNode()
	count[r] = (1 + count[r]) if r in count else 1
print(count)
print("elapsed time: " + str(time.time() - start_time))
