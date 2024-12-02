#백준허브테스트용
N = int(input())
for i in range(N):
    trigger = True
    arr = list(input())
    cnt = 0
    for i in range(len(arr)):
        if arr[i] == '(':
            cnt += 1
        elif arr[i] == ')':
            cnt -= 1
        if cnt < 0:
            print("NO")
            trigger = False
            break
    if trigger:
        if cnt == 0:
            print("YES")
        else:
            print("NO")