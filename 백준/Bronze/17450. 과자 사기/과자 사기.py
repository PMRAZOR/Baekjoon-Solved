def solver(price, weight):
    if price * 10 >= 5000:
        return weight * 10 / (price * 10 - 500)
    else:
        return weight / price

S = list(map(int, input().split()))
N = list(map(int, input().split()))
U = list(map(int, input().split()))

ans_S = solver(S[0], S[1])
ans_N = solver(N[0], N[1])
ans_U = solver(U[0], U[1])

if ans_S > ans_N:
    if ans_S > ans_U:
        print('S')
    else:
        print('U')
else:
    if ans_N > ans_U:
        print('N')
    else:
        print('U')