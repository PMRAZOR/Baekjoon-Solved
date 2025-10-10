def checker(num):
    root_num = int(num ** 0.5)
    if num == root_num * root_num: return True
    return False

N, M = map(int, input().split())
arr = []
ans = -1
for i in range(N):
    temp = input()
    temp_arr = []
    for j in range(M):
        temp_arr.append(int(temp[j]))
    arr.append(temp_arr)

for i in range(N):
    for j in range(M):
        for k in range(-N, N):
            for l in range(-M, M):
                x = i
                y = j
                num = 0
                if l == 0 and k == 0 : continue
                while 0 <= x < N and 0 <= y < M:
                    num = (num * 10) + arr[x][y]
                    # print(num)
                    if checker(num):
                        ans = max(ans, num)
                    x += k
                    y += l
print(ans)

