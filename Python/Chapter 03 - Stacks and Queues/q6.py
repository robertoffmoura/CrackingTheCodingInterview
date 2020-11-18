# pseudo code

class AnimalShelter:
	def __init__(self):
		self.catQueue = Queue()
		self.dogQueue = Queue()

	def enqueueDog(self, dog, time):
		self.dogQueue.add((dog, time))

	def enqueueCat(self, cat, time):
		self.catQueue.add((cat, time))

	def enqueue(self, animal):
		time = now()
		if type(animal) == dogType:
			self.enqueueDog(animal, time)
		elif type(animal) == catType:
			self.enqueueCat(animal, time)

	def dequeueAny(self):
		dog, dogTime = self.dogQueue.peek()
		cat, catTime = self.catQueue.peek()
		if catTime < dogTime:
			self.catQueue.dequeue()
			return cat
		else:
			self.godQueue.dequeue()
			return dog

	def dequeueDog(self):
		if (len(self.dogQueue) == 0):
			print("No dogs left")
			return
		return self.dogQueue.dequeue()[0]

	def dequeueCat(self):
		if (len(self.catQueue) == 0):
			print("No cats left")
			return
		return self.catQueue.dequeue()[0]
