N = int(input())
dp = [0 for _ in range(31)]
dp[0] = 1
dp[1] = 0
dp[2] = 3
if N % 2 == 1:
    print(0)
else:
    for i in range(4, N+1):
        dp[i] = dp[i - 2] * dp[2]
        for j in range(i - 4, -1, -2):
            dp[i] += dp[j] * 2
    print(dp[N])