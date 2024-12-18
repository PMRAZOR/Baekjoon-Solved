N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
arr.sort()

dp = [0 for _ in range(N)]
dp[0] = arr[0][2]

for i in range(1, N):
    dp[i] = max(dp[i - 1], dp[i - 2] + arr[i][2])
print(dp[N - 1])