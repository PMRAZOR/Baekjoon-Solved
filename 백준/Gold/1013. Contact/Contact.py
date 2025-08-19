import re

N = int(input())
arr = [input() for _ in range(N)]
# 10으로 시작하고 0+ 또는 1+ or 01 반복
p = re.compile("^(100+1+|01)+$")
for i in arr:
    if p.match(i):
        print("YES")
    else:
        print("NO")
