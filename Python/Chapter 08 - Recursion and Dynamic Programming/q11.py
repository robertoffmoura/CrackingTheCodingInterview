coins = [25, 10, 5, 1]

def coinCombinations(n, coinIndex=0, memo={}):
	if (n < 0):
		return 0
	if (n == 0):
		return 1
	if (n, coinIndex) in memo:
		return memo[(n, coinIndex)]
	result = 0
	for i in range(coinIndex, len(coins)):
		result += coinCombinations(n - coins[i], i)
	memo[(n, coinIndex)] = result
	return result

def coinCombinations2(n, coinIndex=0, memo={}):
	if (n < 0):
		return 0
	if (n == 0):
		return 1
	if (n, coinIndex) in memo:
		return memo[(n, coinIndex)]
	result = 0
	coin = coins[coinIndex]
	for i in range(0, n+1, coin):
		result += coinCombinations(n - i, coinIndex+1)
	memo[(n, coinIndex)] = result
	return result

print(coinCombinations2(750))
print(coinCombinations(750))
