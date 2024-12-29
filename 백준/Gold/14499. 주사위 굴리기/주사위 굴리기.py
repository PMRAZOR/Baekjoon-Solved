dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]

def turn_up(N, M, dice, arr, x, y):
    if 0 <= x < M and 0 <= y < N:
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = dice[3], dice[0], dice[2], dice[5], dice[4], dice[1]
        if arr[y][x] == 0:
            arr[y][x] = dice[5]
        else:
            dice[5] = arr[y][x]
            arr[y][x] = 0
    return dice

def turn_down(N, M, dice, arr, x, y):
    if 0 <= x < M and 0 <= y < N:
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = dice[1], dice[5], dice[2], dice[0], dice[4], dice[3]
        if arr[y][x] == 0:
            arr[y][x] = dice[5]
        else:
            dice[5] = arr[y][x]
            arr[y][x] = 0
    return dice

def turn_right(N, M, dice, arr, x, y):
    if 0 <= x < M and 0 <= y < N:
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = dice[4], dice[1], dice[0], dice[3], dice[5], dice[2]
        if arr[y][x] == 0:
            arr[y][x] = dice[5]
        else:
            dice[5] = arr[y][x]
            arr[y][x] = 0
    return dice

def turn_left(N, M, dice, arr, x, y):
    if 0 <= x < M and 0 <= y < N:
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = dice[2], dice[1], dice[5], dice[3], dice[0], dice[4]
        if arr[y][x] == 0:
            arr[y][x] = dice[5]
        else:
            dice[5] = arr[y][x]
            arr[y][x] = 0
    return dice

N, M, y, x, K = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
opcode = list(map(int, input().split()))
dice = [0 for _ in range(6)]

for i in opcode:
    printing = True
    if i == 1:
        if 0 <= x + dx[0] < M and 0 <= y + dy[0] < N:
            x += dx[0]
            y += dy[0]
            dice = turn_right(N, M, dice, arr, x, y)
        else:
            printing = False
    elif i == 2:
        if 0 <= x + dx[1] < M and 0 <= y + dy[1] < N:
            x += dx[1]
            y += dy[1]
            dice = turn_left(N, M, dice, arr, x, y)
        else:
            printing = False
    elif i == 3:
        if 0 <= x + dx[2] < M and 0 <= y + dy[2] < N:
            x += dx[2]
            y += dy[2]
            dice = turn_up(N, M, dice, arr, x, y)
        else:
            printing = False
    elif i == 4:
        if 0 <= x + dx[3] < M and 0 <= y + dy[3] < N:
            x += dx[3]
            y += dy[3]
            dice = turn_down(N, M, dice, arr, x, y)
        else:
            printing = False
    if printing:
        print(dice[0])