def getHeight(node):
	result = 0
	while (node is not None):
		node = node.parent
		result += 1
	return result

def firstCommonAncestor(a, b):
	heightA = getHeight(a)
	heightB = getHeight(b)
	maxHeight = max(heightA, heightB)
	for i in range(maxHeight - heightB):
		a = a.parent
	for i in range(maxHeight - heightA):
		b = b.parent
	while (a is not None and b is not None and a != b):
		a = a.parent
		b = b.parent
	return a

def firstCommonAncestorNoParent(a, b, root):
	def AncestorHasAHasB(node, a, b):
		hasA, hasB = (node == a), (node == b)
		if (node.left):
			leftAncestor, leftHasA, leftHasB = AncestorHasAHasB(node.left, a, b)
			if (leftHasA and leftHasB):
				return leftAncestor, leftHasA, leftHasB
			hasA = hasA or leftHasA
			hasB = hasB or leftHasB
		if (node.right):
			rightAncestor, rightHasA, rightHasB = AncestorHasAHasB(node.right, a, b)
			if (rightHasA and rightHasB):
				return rightAncestor, rightHasA, rightHasB
			hasA = hasA or rightHasA
			hasB = hasB or rightHasB
		return (node if hasA and hasB else None), hasA, hasB

	return AncestorHasAHasB(a, b, root)[0]
