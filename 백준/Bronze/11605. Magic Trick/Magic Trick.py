n = int(input())
arr = []
for i in range(n):
    op, x = input().split()
    arr.append((op, int(x)))
cnt = 0
for k in range(1, 101):
    result = k
    valid = True
    for op, x in arr:
        if op == 'ADD':
            result += x
        elif op == 'SUBTRACT':
            result -= x
        elif op == 'MULTIPLY':
            result *= x
        elif op == 'DIVIDE':
            if result % x != 0:
                valid = False
                break
            result //= x
        if result < 0:
            valid = False
            break
    if not valid:
        cnt += 1
print(cnt)