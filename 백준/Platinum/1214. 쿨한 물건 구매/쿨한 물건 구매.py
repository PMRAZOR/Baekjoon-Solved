def ans(D, P, Q):
    P, Q = max(P, Q), min(P, Q)
    cnt = 100000000000

    for i in range(min(D // P, Q) + 1):
        cnt = min(cnt, (Q - (D - P * i) % Q) % Q)
    
    cnt = min(cnt, (P - (D % P)) % P)
    
    return D + cnt

D, P, Q = map(int, input().split())

print(ans(D, P, Q))