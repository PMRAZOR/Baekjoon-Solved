N = int(input())
plus = []
minus = []
result = 0

for i in range(N):
    temp = int(input())
    if temp > 1:
        plus.append(temp)
    elif temp == 1:
        result += 1
    else:
        minus.append(temp)

plus.sort(reverse=True)
minus.sort()

for i in range(0, len(plus), 2):
    if i + 1 >= len(plus):
        result += plus[i]
    else:
        result += plus[i] * plus[i+1]

# 음수 처리
for i in range(0, len(minus), 2):
    if i + 1 >= len(minus):
        result += minus[i]
    else:
        result += minus[i] * minus[i+1]

print(result)