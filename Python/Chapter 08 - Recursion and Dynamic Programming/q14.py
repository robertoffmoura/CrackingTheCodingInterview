def decode(string):
	numbers = []
	operators = []
	for i, c in enumerate(string):
		if i % 2 == 0:
			numbers.append(int(c))
		else:
			operators.append(c)
	return numbers, operators

def evaluate(left, right, operator):
	if operator == "&":
		return left & right
	elif operator == "|":
		return left | right
	elif operator == "^":
		return left ^ right

def closeParentheses(number_stack, operator_stack):
	last = number_stack.pop()
	before_last = number_stack.pop()
	operator = operator_stack.pop()
	result = evaluate(before_last, last, operator)
	number_stack.append(result)

def helper(numbers, operators, target, number_index=0, number_stack=None, operator_stack=[]):
	if number_stack is None:
		number_stack = [numbers[0]]
	if (number_index == len(numbers)-1 and len(number_stack) == 1):
		return 1 * (number_stack[-1] == target)
	result = 0
	if (number_index < len(numbers)-1):
		# print(number_index)
		operator_stack.append(operators[number_index])
		number_index += 1
		number_stack.append(numbers[number_index])
		result += helper(numbers, operators, target, number_index, number_stack.copy(), operator_stack.copy())
		number_stack.pop()
		number_index -= 1
		operator_stack.pop()
	if (len(number_stack) > 1):
		closeParentheses(number_stack, operator_stack)
		result += helper(numbers, operators, target, number_index, number_stack.copy(), operator_stack.copy())
	return result



def booleanEvaluation(string, target):
	numbers, operators = decode(string)
	return helper(numbers, operators, target)

print(booleanEvaluation("1^0|0|1", False))
print(booleanEvaluation("0&0&0&1^1|0", True))
