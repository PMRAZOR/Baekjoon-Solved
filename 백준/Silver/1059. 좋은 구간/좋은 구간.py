def solver(arr, index, N):
    first_num = 1
    if index == 0:
        first_num = 1
    else:
        first_num = arr[index - 1] + 1
    last_num = arr[index] - 1
    return (N - first_num) * (last_num - N + 1) + last_num - N


L = int(input())
S = list(map(int, input().split()))
N = int(input())

S.sort()
index = 0

for i in range(L):
    if S[i] > N:
        index = i
        break

ans = solver(S, index, N)
if ans < 0:
    ans = 0
print(ans)