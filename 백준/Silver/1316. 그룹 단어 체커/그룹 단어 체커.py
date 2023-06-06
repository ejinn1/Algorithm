n = int(input())

wordLsit = []

for _ in range(n):
    wordLsit.append(input())

for word in wordLsit:
    for i in range(0, len(word)-1):
        if word[i] == word[i+1]:
            pass
        elif word[i] in word[i+1:]:
            n -= 1
            break
        
print(n)
        