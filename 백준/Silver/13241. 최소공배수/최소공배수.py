def solver(a, b):
    while True:
        if b == 0:
            return a
        a, b = b, a % b

a, b = map(int, input().split())

ans = 0
if a > b:
    ans = solver(a, b)
else:
    ans = solver(b, a)

print(a * b //ans)