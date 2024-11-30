mod = 1000000007
max_n = 4000000

def pre_fac(max_n):
    fac = [1] * (max_n + 1)
    for i in range(1, max_n + 1):
        fac[i] = (fac[i - 1] * i % mod)
    return fac

factorials = pre_fac(max_n)

def nCk(n, k):
    return (factorials[n] * pow(factorials[k] * factorials[n - k], mod - 2, mod)) % mod

def doFac(num):
    A = 1
    for i in range(1, num + 1):
        A = (A * i) % mod
    return A

M = int(input())
for _ in range(M):
    n, k = map(int, input().split())
    print(nCk(n, k))