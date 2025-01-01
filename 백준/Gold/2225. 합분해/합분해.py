N, K = map(int, input().split())
dp = [[1 for _ in range(N + 1)] for _ in range(K + 1)]

for i in range(2, K + 1):
    for j in range(1, N + 1):
        dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000

print(dp[K][N])