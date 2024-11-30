N = int(input())
arr = []
for i in range(N):
    B, P, Q, T = map(int, input().split())
    arr.append([B, P * Q * T, P + Q + T])
arr.sort(key=lambda x: (x[1], x[2], x[0]))
for i in range(3):
    print(arr[i][0], end = " ")