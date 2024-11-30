d = []
s = 0
for i in range(9):
    d.append(int(input()))
    s = s + d[i]
s = s - 100
l = 0
o = 0
for j in range(len(d)):
    for k in range(len(d)):
        if d[j] + d[k] == s and j is not k:
            l = j
            o = k
del d[l]
del d[o]
d.sort()
for y in range(len(d)):
    print(d[y])