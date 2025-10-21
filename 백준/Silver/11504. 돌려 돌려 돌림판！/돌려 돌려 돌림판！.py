TC = int(input())
for _ in range(TC):
    N, M = map(int, input().split())
    X = 0
    Y = 0
    X_arr = list(map(int, input().split()))
    Y_arr = list(map(int, input().split()))
    for i in range(M):
        X = X * 10 + X_arr[i]
        Y = Y * 10 + Y_arr[i]
    arr = list(map(int, input().split()))
    count = 0
    for i in range(N):
        if X_arr[0] <= arr[i] <= Y_arr[0]:
            curr = 0
            for j in range(M):
                now = (i + j) % N
                curr = curr * 10 + arr[now]
            if X <= curr <= Y: count += 1
    print(count)
