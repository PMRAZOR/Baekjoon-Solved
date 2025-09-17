word = input()

word1 = "KOREA"
word2 = "YONSEI"
stat1 = 0
stat2 = 0

for i in range(len(word)):
    if stat1 == 5:
        print("KOREA")
        break
    if stat2 == 6:
        print("YONSEI")
        break
    if word[i] == word1[stat1]:
        stat1 += 1
    if word[i] == word2[stat2]:
        stat2 += 1