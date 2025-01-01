TC = int(input())

for _ in range(TC):
    N = int(input())
    arr = list(map(int, input().split()))
    accu = [0] * (N + 1)
    for i in range(1, N + 1):
        accu[i] = accu[i - 1] + arr[i - 1]
    dp = [[0 for _ in range(N + 1)] for _ in range(N + 1)]
    
    for i in range(2, N +1 ): # 부분 파일의 길이
        for j in range(1, N + 2 - i):   # 시작점
            dp[j][j + i - 1] = min([dp[j][j + k] + dp[j + k + 1][j + i - 1] for k in range(i - 1)]) + (accu[j + i - 1] - accu[j - 1])

    print(dp[1][N])