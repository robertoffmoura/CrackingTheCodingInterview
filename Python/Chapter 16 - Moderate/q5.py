def fractionalZeros(n):
	zeroCount = 0
	multiple = 5
	while (multiple <= n):
		zeroCount += n//multiple
		multiple *= 5
	return zeroCount

print(fractionalZeros(4))
print(fractionalZeros(5))
print(fractionalZeros(6))
print(fractionalZeros(9))
print(fractionalZeros(10))
print(fractionalZeros(11))
print(fractionalZeros(14))
print(fractionalZeros(15))
print(fractionalZeros(16))
print(fractionalZeros(19))
print(fractionalZeros(20))
print(fractionalZeros(21))
print(fractionalZeros(24))
print(fractionalZeros(25))
print(fractionalZeros(26))
