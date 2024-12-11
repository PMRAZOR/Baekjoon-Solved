k, start, end = map(int, input().split())

if start == 0 or end == 0 or (start < 0 and end > 0):  # 0을 포함하는 경우
    result = 1 + abs(start) // k + end // k
else:  # 한쪽에 치우친 경우
    start = abs(start)
    end = abs(end)

    if start > end:
        start, end = end, start  # 무조건 end가 더 크게 만들기

    result = end // k - start // k
    if start % k == 0:
        result += 1

print(result)