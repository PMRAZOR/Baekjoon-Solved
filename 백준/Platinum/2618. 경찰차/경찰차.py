def distance(a, b):
    return abs(a[0] - b[0]) + abs(a[1] - b[1])

def solve(m, n):
    if max(m, n) == W+1:
        return 0
    
    if dp[m][n] != -1:
        return dp[m][n]
    
    next_event = max(m, n) + 1
    
    dist1 = solve(next_event, n) + distance(events[m], events[next_event])
    dist2 = solve(m, next_event) + distance(events[n], events[next_event])
    
    if dist1 < dist2:
        dp_trace[m][n] = 1
        dp[m][n] = dist1
    else:
        dp_trace[m][n] = 2
        dp[m][n] = dist2
    
    return dp[m][n]

N = int(input())
W = int(input())
events = [(1, 1), (N, N)] + [tuple(map(int, input().split())) for _ in range(W)]

dp = [[-1] * (W + 2) for _ in range(W + 2)]
dp_trace = [[-1] * (W + 2) for _ in range(W + 2)]

min_dist = solve(0, 1)
print(min_dist)

result = []
m, n = 0, 1
for _ in range(W):
    next_move = dp_trace[m][n]
    result.append(next_move)
    if next_move == 1:
        m = max(m, n) + 1
    else:
        n = max(m, n) + 1

for car in result:
    print(car)