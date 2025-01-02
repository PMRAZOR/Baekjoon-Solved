N = int(input())
arr = list(map(int, input().split()))

dp = [0 for _ in range(N + 1)]

for i in range(N):
    index = arr[i]
    dp[index] = dp[index - 1] + 1

print(N - max(dp))