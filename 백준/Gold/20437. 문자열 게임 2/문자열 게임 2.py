# superaquatornado
TC = int(input())
for _ in range(TC):
    words = input()
    words_num = [0 for _ in range(26)]
    more_than_two = []
    find_arr = []
    K = int(input())
    for i in words:
        words_num[ord(i) - 97] += 1
    for j in range(26):
        if words_num[j] >= K:
            word = chr(j + 97)
            word_index = list(filter(lambda x: words[x] == word, range(len(words))))
            find_arr.append(word_index)
    min_len = 9999999
    max_len = 0
    for k in find_arr:
        for i in range(len(k) - K + 1): # 0, 1, 2
            # print(k)
            diff = 0
            for j in range(1, K): # 1, 2
                diff += k[i + j] - k[i + j - 1]
                # print("diff =", diff, ":", k[i + j], "-", k[i + j - 1])
            # print(diff)
            min_len = min(diff + 1, min_len)
            max_len = max(diff + 1, max_len)

    print(min_len, max_len) if min_len != 9999999 and max_len != 0 else print(-1)