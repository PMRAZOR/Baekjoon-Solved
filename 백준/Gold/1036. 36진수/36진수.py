def dec_to_36(dec):
    if dec == 0: return "0"

    d = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    result = ""

    while dec > 0:
        result = d[dec % 36] + result
        dec //= 36
        
    return result

def z_diff(ori36, z36):
    ori_dec = int(ori36, 36)
    z_dec = int(z36, 36)
    return z_dec - ori_dec

N = int(input())
arr = []
diff_arr = {}

for i in range(N):
    arr.append(input())
    word = list(arr[i])
    w_len = len(word)

    for j in range(w_len):
        origin_word = word[j] + "0" * (w_len - j - 1)
        z_word = "Z" + "0" * (w_len - j - 1)

        if word[j] in diff_arr:
            diff_arr[word[j]] += z_diff(origin_word, z_word)
        else:
            diff_arr[word[j]] = z_diff(origin_word, z_word)

diff_arr = [(word, dec) for word, dec in diff_arr.items()]
diff_arr.sort(key=lambda x: x[1], reverse=True)

dec = 0
for i in arr:
    dec += int(i, 36)

K = int(input())

for i in range(K if len(diff_arr) > K else len(diff_arr)):
    dec += diff_arr[i][1]

print(dec_to_36(dec))