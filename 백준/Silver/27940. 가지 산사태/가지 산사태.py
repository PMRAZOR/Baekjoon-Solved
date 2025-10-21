N, M, K = map(int, input().split())

count = 0
time = 0
ans = 0
temp = 1000000

for i in range(M):
    floor, many = map(int, input().split())
    count += many
    time += 1
    temp = min(temp, floor)

    if count > K:
        ans += temp
        break

print(time, ans) if not ans == 0 else print(-1)