N = int(input())
M = int(input())
arr = [[99999999] * (N + 1) for _ in range(N + 1)]

# 배열에 넣기
for i in range(M):
    a, b, c = map(int, input().split())
    if arr[a][b] > c:
        arr[a][b] = c

# 배열 동일선상 0으로
for i in range(N + 1):
    arr[i][i] = 0

# 점화식
for k in range(1, N + 1):
    for a in range(1, N + 1):
        for b in range(1, N + 1):
            arr[a][b] = min(arr[a][b], arr[a][k] + arr[k][b])

for i in range(1, N + 1):
    for j in range(1, N + 1):
        if arr[i][j] == 99999999:
            print(0, end=" ")
        else: print(arr[i][j], end=" ")
    print()