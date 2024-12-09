def find_parent(node):
    if arr[node] != node:
        arr[node] = find_parent(arr[node])
    return arr[node]

def union_parent(a, b):
    a = find_parent(a)
    b = find_parent(b)
    if a < b:
        arr[b] = a
    else:
        arr[a] = b

G = int(input())
arr = [i for i in range(G + 1)]
P = int(input())
cnt = 0

planes = []
for i in range(P):
    planes.append(int(input()))

for i in planes:
    temp = find_parent(i)
    if temp == 0: break
    union_parent(temp, temp - 1)
    cnt += 1

print(cnt)