def row_flip(arr, row, N):
    for i in range(N):
        arr[row][i] = 1 - arr[row][i]

def solver(arr, N):
    ans = N * N
    for i in range(1 << N):
        temp_arr = [row[:] for row in arr]
        
        for j in range(N):
            if i & (1 << j):
                row_flip(temp_arr, j, N)
        
        temp_sum = 0
        for j in range(N):
            cnt = sum(temp_arr[k][j] for k in range(N))
            temp_sum += min(cnt, N - cnt)
        
        ans = min(ans, temp_sum)
    return ans

N = int(input())
arr = [[0 for _ in range(N)] for _ in range(N)]

for i in range(N):
    temp = input().strip()
    for j in range(N):
        if temp[j] == 'T':
            arr[i][j] = 1

print(solver(arr, N))