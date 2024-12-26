N = int(input())
crane = list(map(int, input().split()))
M = int(input())
box = list(map(int, input().split()))

crane.sort(reverse=True)
box.sort(reverse=True)

if crane[0] < box[0]:
    print(-1)
    exit()

visited = [False for _ in range(N)]
cnt = 0

while 0 < len(box):
    for i in range(N):
        if not visited[i]:
            for j in range(len(box)):
                if crane[i] >= box[j]:
                    visited[i] = True
                    box.pop(j)
                    break
    cnt += 1
    visited = [False for _ in range(N)]
print(cnt)