import sys

def sol(k, n):
    global cnt
    if k == n:
        cnt += 1
        return cnt

    for i in range(n):
        if not used[i] and not used_down[k + i] and not used_up[(n - 1) + k - i]:
            used[i] = True
            used_down[k + i] = True
            used_up[(n - 1) + k - i] = True
            sol(k + 1, n)
            used[i] = False
            used_down[k + i] = False
            used_up[(n - 1) + k - i] = False

n = int(input())
map = [[0]*n for _ in range(n)]

used = [False] * n
used_up = [False] * ( 2 * (n - 1) + 1)
used_down = [False] * ( 2 * (n - 1) + 1)

cnt = 0
sol(cnt, n)
print(cnt)