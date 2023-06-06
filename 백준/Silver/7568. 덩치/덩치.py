n = int(input())
sizeList = []

for _ in range(n):
    x, y = map(int, input().split())
    sizeList.append((x, y))
    
for size in sizeList:
    rank = 1
    for compare in sizeList:
        if compare[0] > size[0] and compare[1] > size[1]:
            rank += 1
    print(rank, end=' ')