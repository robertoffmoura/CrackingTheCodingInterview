def recursiveMultiply(a, b):
	if (a == 0 or b == 0):
		return 0
	if (a < 0 and b < 0):
		return recursiveMultiply(-a, -b)
	if ((a > 0) != (b > 0)):
		return -recursiveMultiply(abs(a), abs(b))
	if (a < b):
		return recursiveMultiply(b, a)
	return a + recursiveMultiply(a, b-1)

print(recursiveMultiply(1, 2))
print(recursiveMultiply(4, 5))
print(recursiveMultiply(-4, -5))
print(recursiveMultiply(-4, 5))

def bitShiftMultiply(a, b):
	if (a < 0 and b < 0):
		return recursiveMultiply(-a, -b)
	if ((a > 0) != (b > 0)):
		return -recursiveMultiply(abs(a), abs(b))
	if (a < b):
		return bitShiftMultiply(b, a)
	result = 0
	bit = 1
	i = 0
	while (bit <= a):
		if bit & b != 0:
			result += (a << i)
		bit <<= 1
		i += 1
	return result

print(bitShiftMultiply(1, 2))
print(bitShiftMultiply(4, 5))
print(bitShiftMultiply(-4, -5))
print(bitShiftMultiply(-4, 5))
