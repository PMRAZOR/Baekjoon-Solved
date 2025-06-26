N = int(input())
queue = []
ans = []

for i in range(1, N+1):
    queue.append(i)

case = 0
while len(queue) > 1:
    if case == 0:
        ans.append(queue.pop(0))
        case = 1
    else:
        queue.append(queue.pop(0))
        case = 0

ans.append(queue.pop(0))
print(*ans)