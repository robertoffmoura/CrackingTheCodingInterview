def peaksAndValleys(l):
	n = len(l)
	for i in range(n-1):
		if i%2 == 0 and l[i] < l[i+1]:
			l[i], l[i+1] = l[i+1], l[i]
		elif i%2 != 0 and l[i] > l[i+1]:
			l[i], l[i+1] = l[i+1], l[i]

l = [5, 3, 1, 2, 3]
print(l)
peaksAndValleys(l)
print(l)
