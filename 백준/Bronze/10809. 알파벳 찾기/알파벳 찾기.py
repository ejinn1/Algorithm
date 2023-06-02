word = input()
alpha = list(range(97,123))

for x in alpha:
    print(word.find(chr(x)))