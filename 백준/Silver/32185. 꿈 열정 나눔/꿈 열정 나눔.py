N, M = map(int, input().split())
my_stat = sum(list(map(int, input().split())))
team_stat = []
for i in range(N):
    temp = sum(list(map(int, input().split())))
    if my_stat >= temp: team_stat.append([i + 1, temp])
    else: continue
team_stat.sort(key=lambda x: x[1], reverse=True)
print(0, end=" ")
for i in range(min(M - 1, len(team_stat))):
    print(team_stat[i][0], end=" ")