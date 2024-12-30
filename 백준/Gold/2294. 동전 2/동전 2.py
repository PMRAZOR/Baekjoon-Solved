N, K = list(map(int, input().split()))
arr = [int(input()) for _ in range(N)]

dp = [99999 for i in range(K + 1)]
dp[0] = 0

for i in range(N):
    for j in range(arr[i], K + 1):
        dp[j] = min(dp[j], dp[j - arr[i]] + 1)
        
if dp[K] == 99999:
    print(-1)
else:
    print(dp[K])