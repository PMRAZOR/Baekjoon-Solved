from collections import deque

N = int(input())
K = int(input())
arr = [[0 for _ in range(N)] for _ in range(N)]
# 사과 위치 입력
for i in range(K):
    temp = input().split()
    x = int(temp[0]) - 1
    y = int(temp[1]) - 1
    arr[x][y] = -1  # 사과는 -1로 표시

L = int(input())
rotate = deque()  # deque로 변경
for i in range(L):
    temp = input().split()
    time = int(temp[0])
    direction = temp[1]
    rotate.append([time, direction])

cnt = 0
snake = deque()
snake.append([0, 0])
arr[0][0] = 1  # 뱀의 위치는 1로 표시
move = [(0, 1), (1, 0), (0, -1), (-1, 0)]  # 우, 하, 좌, 상
direction = 0

while True:
    x, y = snake[-1]  # 뱀의 머리 위치
    nx = x + move[direction][0]
    ny = y + move[direction][1]
    
    # 벽에 부딪히거나 자기자신과 부딪힌 경우
    if nx < 0 or nx >= N or ny < 0 or ny >= N or arr[nx][ny] == 1:
        cnt += 1  # 마지막 이동까지 포함
        break
        
    # 사과가 있는 경우
    if arr[nx][ny] == -1:
        arr[nx][ny] = 1
        snake.append([nx, ny])
    # 사과가 없는 경우
    else:
        arr[nx][ny] = 1
        snake.append([nx, ny])
        tx, ty = snake.popleft()
        arr[tx][ty] = 0
    
    cnt += 1
    
    # 방향 전환 확인
    if rotate and cnt == rotate[0][0]:
        if rotate[0][1] == 'L':
            direction = (direction - 1) % 4
        else:  # 'D'인 경우
            direction = (direction + 1) % 4
        rotate.popleft()

print(cnt)