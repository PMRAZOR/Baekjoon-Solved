check = [0 for i in range(10)]

def calc(n, ten):
    while n > 0:
        check[n % 10] += ten
        n //= 10

def solve(A, B, ten):
    # A를 증가시키면서 0을 만든다.
    while A % 10 != 0 and A <= B:
        # A를 증가시킬 때는 calc를 거쳐야 한다.
        calc(A, ten)
        A += 1
    
    if A > B:
        return
    
    while B % 10 != 9 and B >= A:
        calc(B, ten)
        B -= 1
    
    cnt = (B // 10 - A // 10 + 1)
    for i in range(10):
        check[i] += cnt * ten
    
    # 다음 자리수를 계산하기 위해 재귀함수 호출
    solve(A // 10, B // 10, ten * 10)

n = int(input())
solve(1, n, 1)
print(*check)