def numberSwapper(a, b):
	a[0] = a[0] + b[0]
	b[0] = a[0] - b[0]
	a[0] = a[0] - b[0]

a = [1]
b = [2]
print(a, b)
numberSwapper(a, b)
print(a, b)
