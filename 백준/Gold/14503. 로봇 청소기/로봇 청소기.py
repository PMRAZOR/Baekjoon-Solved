def solver(arr, i, j, d):
    # 0: 북, 1: 동, 2: 남, 3: 서
    di = [-1, 0, 1, 0]
    dj = [0, 1, 0, -1]
    cnt = 1
    arr[i][j] = 2
    while True:
        for _ in range(4):
            d = (d + 3) % 4
            ni = i + di[d]
            nj = j + dj[d]
            if 0 <= ni < N and 0 <= nj < M and arr[ni][nj] == 0:
                arr[ni][nj] = 2
                i, j = ni, nj
                cnt += 1
                break
        else:
            ni = i + di[(d + 2) % 4]
            nj = j + dj[(d + 2) % 4]
            if 0 <= ni < N and 0 <= nj < M and arr[ni][nj] == 1:
                break
            else:
                i, j = ni, nj
    return cnt

N, M = map(int, input().split())
i, j, d = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
print(solver(arr, i, j, d))