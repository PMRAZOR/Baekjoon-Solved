N = int(input())
ans = 0

while N % 5:
    N -= 3
    ans += 1

if N < 0:
    print(-1)
else:
    print(ans + N // 5)