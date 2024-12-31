from collections import deque

N = int(input())
cost = [0 for _ in range(N + 1)]
before = [[] for _ in range(N + 1)]
indegree = [0 for _ in range(N + 1)]
total = [0 for _ in range(N + 1)]

for i in range(1, N + 1):
    temp = list(map(int, input().split()))[:-1]
    cost[i] = temp[0]
    for j in temp[1:]:
        before[j].append(i)
        indegree[i] += 1
        
q = deque()

for i in range(1, N + 1):
    if indegree[i] == 0:
        total[i] = cost[i]
        q.append(i)
        
while q:
    current = q.popleft()
    
    for i in before[current]:
        indegree[i] -= 1
        total[i] = max(total[i], total[current] + cost[i])
        
        if indegree[i] == 0:
            q.append(i)

for i in total[1:]:
    print(i)