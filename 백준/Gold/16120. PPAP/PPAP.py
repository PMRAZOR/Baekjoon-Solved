string = list(input().strip())
target = ['P', 'P', 'A', 'P']
stack = []

for i in string:
    stack.append(i)
    if stack[-4:] == target:
        for _ in range(4):
            stack.pop()
        stack.append('P')
if stack == target or stack == ['P']:
    print('PPAP')
else:
    print('NP')