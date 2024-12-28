dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def solve_1(N, M, arr, i, j, time, cnt, visited):
    if time >= 3:
        return cnt + arr[i][j]
    
    visited[i][j] = True
    max_sum = 0
    
    for k in range(4):
        nx = i + dx[k]
        ny = j + dy[k]
        
        if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny]:
            max_sum = max(max_sum, solve_1(N, M, arr, nx, ny, time + 1, cnt + arr[i][j], visited))
    visited[i][j] = False
    
    return max_sum

def solve_2(N, M, arr, i, j):
    tetromino = [
        [(0,0), (0,1), (0,2), (-1,1)],  # ㅗ
        [(0,0), (0,1), (0,2), (1,1)],   # ㅜ
        [(0,0), (1,0), (2,0), (1,1)],   # ㅏ
        [(0,0), (1,0), (2,0), (1,-1)]   # ㅓ
    ]
    
    max_sum = 0
    for t in tetromino:
        current_sum = 0
        is_valid = True
        
        for di, dj in t:
            ni = i + di
            nj = j + dj
            if not (0 <= ni < N and 0 <= nj < M):
                is_valid = False
                break
            current_sum += arr[ni][nj]
            
        if is_valid:
            max_sum = max(max_sum, current_sum)
            
    return max_sum

def main_solver(N, M, arr):
    max_result = 0
    visited = [[False] * M for _ in range(N)]
    
    for i in range(N):
        for j in range(M):
            max_result = max(max_result, solve_1(N, M, arr, i, j, 0, 0, visited))
            max_result = max(max_result, solve_2(N, M, arr, i, j))
    
    return max_result

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

result = main_solver(N, M, arr)
print(result)