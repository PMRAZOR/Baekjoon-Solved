N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
dp = [1 for _ in range(N)]

arr.sort(key=lambda x: (x[0], x[1]))

for i in range(N):
    for j in range(i):
        if arr[i][0] > arr[j][0] and arr[i][1] > arr[j][1]:
            dp[i] = max(dp[i], dp[j] + 1)
print(N - max(dp))