def solver(arr):
    for i in range (1, M):
        arr[0][i] = arr[0][i - 1] + 1
    for j in range (1, N):
        for i in range(M):
            arr[j][i] = arr[j - 1][i] + 1

N, M, K = map(int, input().split())
arr = [[0 for _ in range (M)] for _ in range (N)]
arr[0][0] = 1
solver(arr)
if K >= arr[N - 1][M - 1]:
    print("YES")
    for i in range (N):
        for j in range (M):
            print(arr[i][j], end=" ")
        print()
else: print("NO")