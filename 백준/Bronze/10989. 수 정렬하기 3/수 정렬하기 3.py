import sys

n = int(sys.stdin.readline())
count = [0] * 10001  # 수의 범위가 10000까지라고 가정

# 입력받으면서 바로 카운팅
for _ in range(n):
    count[int(sys.stdin.readline())] += 1

# 카운팅된 값을 순서대로 출력
for i in range(10001):
    if count[i] != 0:
        for _ in range(count[i]):
            print(i)