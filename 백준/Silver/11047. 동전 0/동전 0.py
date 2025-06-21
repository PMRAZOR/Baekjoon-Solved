N, M = map(int, input().split())
arr = [0 for _ in range(N + 1)]

arr[N] = 100000001

for i in range(N):
    arr[i] = int(input())

dp = [0 for _ in range(N + 1)]

for i in range(N):
    # print("now", i, M)

    if arr[i] > M:
        # print(i , "case end")
        break

    if M % arr[i + 1] == 0:
        # print(i , "case skip")
        continue
    elif arr[i + 1] == 100000001 or arr[i + 1] > M:
        # print(i , "case 2")
        dp[i] = M // arr[i]
        M -= dp[i] * arr[i]
    elif arr[i + 1] < M:
        # print(i , "case 1")
        dp[i] = (M % arr[i + 1]) // arr[i]
        M -= dp[i] * arr[i]

print(sum(dp))