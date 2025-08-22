a = input() # 11
b = input() # 16
dp = [[0] * (len(a) + 1) for _ in range(len(b) + 1)]

ans = 0

for i in range(1, len(a) + 1):
    for j in range(1, len(b) + 1):
        if a[i - 1] == b[j - 1]:
            dp[j][i] = 1 + dp[j - 1][i - 1]
            ans = max(ans, dp[j][i])
        else:
            dp[j][i] = 0

print(ans)