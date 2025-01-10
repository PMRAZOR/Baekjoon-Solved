N, M = map(int, input().split())
if M == 0:
    print(0)
    exit()
S = list(map(int, input().split()))

ans = 9999999999

for i in range(1, 1002):
    if i in S:
        continue
    for j in range(1, 1002):
        if j in S:
            continue
        for k in range(1, 1002):
            if k in S:
                continue
            temp = abs(N - (i * j * k))
            if temp < ans and temp >= 0:
                ans = temp
            elif temp > N + 1:
                break
print(ans)