n = int(input())

cand = []
for i in range(61):
    I = 1 << i  
    for j in range(i, 61):
        J = 1 << j  
        cand.append([I + J, i, j])
        
cand.sort()
cand = [cand[i] for i in range(len(cand)) if i == 0 or cand[i] != cand[i-1]]

for _ in range(n):
    m = int(input())
    
    a = [-1, -1, -1]  
    b = [-1, -1, -1]  
    c = [-1, -1, -1]  
    
    for sum_val, i, j in cand:
        if sum_val < m:
            if a[0] == -1 or sum_val > a[0] or (sum_val == a[0] and i < a[1]):
                a = [sum_val, i, j]
        elif sum_val == m:
            if b[0] == -1:
                b = [sum_val, i, j]
        else:
            c = [sum_val, i, j]
            break
    
    if b[0] != -1:
        print(b[1], b[2])
    elif a[0] == -1:
        print(c[1], c[2])
    else:
        if m - a[0] <= c[0] - m:
            print(a[1], a[2])
        else:
            print(c[1], c[2])