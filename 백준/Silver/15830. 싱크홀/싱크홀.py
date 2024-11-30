V, W, D = map(float, input().split())

T = W / V
DD = 0
ans = -1

while DD < D:
    ans += 1
    DD += 5 * T * T
    T *= 1.25

print(ans)