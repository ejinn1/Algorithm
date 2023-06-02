word = input()
f = 1

for i in range(0, len(word)):
    if word[i] != word[-(i + 1)]:
        f = 0
        break
    
print(f)