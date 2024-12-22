N = int(input())
arr = []
cost = []

for i in range(N):
    temp = input()
    arr.append(temp)
    for j in range(len(temp)):
        # 여기서만 수정: 10의 거듭제곱으로 가중치 계산
        cost.append([temp[j], 10 ** (len(temp) - j - 1)])

# 중복된 알파벳의 가중치를 합산
result = {}
for char, value in cost:
    if char in result:
        result[char] += value  # max 대신 더하기로 변경
    else:
        result[char] = value

cost = [[char, value] for char, value in result.items()]
cost.sort(key=lambda x: (-x[1], x[0]))

value = 9
for i in cost:
    i[1] = value
    value -= 1

num = []
for i in arr:
    temp = ''
    for j in i:
        for k in cost:
            if j == k[0]:
                temp += str(k[1])
    num.append(int(temp))
print(sum(num))