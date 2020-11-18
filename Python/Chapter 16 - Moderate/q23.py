import random

def rand5():
	return int(random.random() * 5)

def rand7():
	r = rand5()*5 + rand5()
	if (r < 21):
		return r%7
	else:
		return rand7()

n = 100000
d = {i:0 for i in range(7)}
for i in range(n):
	r = rand7()
	d[r] += 1
d = {i:d[i]/n for i in d}
print(d)
