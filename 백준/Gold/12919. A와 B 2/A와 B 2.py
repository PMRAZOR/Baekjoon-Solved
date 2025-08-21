def solver(S, T):
    if len(S) > len(T): return 0

    if len(S) == len(T):
        if S == T: return 1
        else: return 0

    if T[-1] == "A":
        next_T = T[:-1]
        if solver(S, next_T): return 1
    
    if T[0] == "B":
        next_T = T[1:]
        reverse_T = next_T[::-1]
        if solver(S, reverse_T): return 1
    
    return 0

S = input()
T = input()
print(solver(S, T))
