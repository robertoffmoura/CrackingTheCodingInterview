from collections import deque
n = 10

def towersOfHanoi(s1, s2, s3, n):
	# moves the top n disks from s1 to s3
	if (n == 0):
		return
	towersOfHanoi(s1, s3, s2, n-1)
	if (len(s3) > 0 and s1[-1] > s3[-1]):
		print("error")
	s3.append(s1.pop())
	towersOfHanoi(s2, s1, s3, n-1)

s1 = deque()
s2 = deque()
s3 = deque()
for i in range(n):
	s1.append(n-1-i)

towersOfHanoi(s1, s2, s3, n)
for i in range(n):
	print(s3.pop())
