def checker (party, know, now):
    queue = [now]
    visited = [False] * (N + 1)
    while queue:
        q_now = queue.pop(0)
        visited[q_now] = True
        for i in range(M):
            now_party = party[i]
            if q_now in now_party:
                for j in range(len(now_party)):
                    # print(now_party, q_now, now_party[j])
                    know[now_party[j]] = True
                    if q_now != now_party[j] and not visited[now_party[j]]:
                        queue.append(now_party[j])

N, M = map(int, input().split())

know = [False] * (N + 1)
know_list = list(map(int, input().split()))
many = know_list.pop(0)

party = []
for i in range(M):
    party.append(list(map(int, input().split())))
    party[i].pop(0)

for i in range(many):
    checker(party, know, know_list[i])

ans = 0

for i in range(M):
    now = party[i]
    for j in range(len(now)):
        if know[now[j]]:
            ans += 1
            break
print(M - ans)