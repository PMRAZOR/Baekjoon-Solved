arr = list(map(str, input().strip()))
d1, d2, d3 = map(int, input().split())
fixed_dice = [d1, d2, d3]
result = [0 for _ in range(12)]

# Check ACE ~ HEXA
for i in range(1, 7):
    if i in fixed_dice:
        sum = i * 2
        if d1 == i: sum += d1
        if d2 == i: sum += d2
        if d3 == i: sum += d3
        result[i - 1] = sum
    else:
        result[i - 1] = i * 2

# Four of a Kind and Full House
if d1 == d2 and d1 != d3:
    result[6] = (d1 * 4)
    if d1 > d3:
        result[7] = (d1 * 3) + (d3 * 2)
    else:
        result[7] = (d1 * 2) + (d3 * 3)
elif d1 == d3 and d1 != d2:
    result[6] = (d1 * 4)
    if d1 > d2:
        result[7] = (d1 * 3) + (d2 * 2)
    else:
        result[7] = (d1 * 2) + (d2 * 3)
elif d2 == d3 and d1 != d2:
    result[6] = (d2 * 4)
    if d1 > d2:
        result[7] = (d1 * 3) + (d2 * 2)
    else:
        result[7] = (d1 * 2) + (d2 * 3)

# Small Straight and Large Straight
sorted_dice = sorted(fixed_dice)
if sorted_dice[2] != 6 and d1 != d2 and d1 != d3 and d2 != d3:
    result[8] = 30
elif sorted_dice[0] == 2 and d1 != d2 and d1 != d3 and d2 != d3:
    result[9] = 30

# 개추
if d1 == d2 == d3:
    result[6] = (d1 * 4)
    result[10] = 50
    if d1 != 6:
        result[7] = (d1 * 3) + (6 * 2)
    else:
        result[7] = (d1 * 3) + (5 * 2)

# Choice
result[11] = d1 + d2 + d3 + 6 + 6

# print(*result)

# Finally
ans = 0
for i in range(12):
    if arr[i] == 'Y':
        ans = max(ans, result[i])

print(ans)