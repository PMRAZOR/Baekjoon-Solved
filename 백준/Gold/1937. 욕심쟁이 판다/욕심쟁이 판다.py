import sys
sys.setrecursionlimit(10000)

def dfs(y, x):
    if dp[y][x]:
        return dp[y][x]
    else:
        dp[y][x] = 1
        for dy, dx in [-1, 0],[1, 0],[0, -1],[0, 1]:
            ny, nx = y + dy, x + dx
            if 0 <= ny < n and 0 <= nx < n:
                if arr[ny][nx] > arr[y][x]:
                    dp[y][x] = max(dp[y][x], dfs(ny, nx) + 1)
        return dp[y][x]

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
dp = [[0] * n for _ in range(n)]

ans = 0

for i in range(n):
    for j in range(n):
        if not dp[i][j]:
            ans = max(ans, dfs(i, j))

print(ans)