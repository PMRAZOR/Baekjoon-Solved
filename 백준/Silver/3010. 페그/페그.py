def solver(arr, i, j):
    temp = 0
    if i > 1 and arr[i - 2][j] != ' ' and arr[i - 2][j] != '.' and arr[i - 1][j] != '.':
        temp += 1
    if i < 5 and arr[i + 2][j] != ' ' and arr[i + 2][j] != '.' and arr[i + 1][j] != '.':
        temp += 1
    if j > 1 and arr[i][j - 2] != ' ' and arr[i][j - 2] != '.' and arr[i][j - 1] != '.':
        temp += 1
    if j < 5 and arr[i][j + 2] != ' ' and arr[i][j + 2] != '.' and arr[i][j + 1] != '.':
        temp += 1
    return temp

arr = [list(input().strip('')) for _ in range(7)]
cnt = 0
for i in range(7):
    for j in range(7):
        if arr[i][j] == '.':
            cnt += solver(arr, i, j)
print(cnt)