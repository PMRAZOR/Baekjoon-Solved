m = int(input())
max_multi = 400000
arr = []
temp = 1
while (temp*temp*temp < max_multi):
    arr.append(temp*temp*temp)
    temp += 1

sums = {}
for i in range(len(arr)):
    for j in range(i, len(arr)):
        s = arr[i] + arr[j]
        if s > m: break
        if s in sums:
            sums[s].append((i, j))
        else:
            sums[s] = [(i, j)]

bus_numbers = [num for num, ways in sums.items() if len(ways) >= 2]

if bus_numbers:
    print(max(bus_numbers))
else:
    print("none")