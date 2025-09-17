def solver(num):
    for i in range (2, 1000000):
        if num % i == 0:
            return False
    return True

TC = int(input())
for _ in range (TC):
    num = int(input())
    if not solver(num): print("NO")
    else: print("YES")
