n = int(input())

A = set(map(int, input().split()))
# print(A)

m = int(input())
B = list(map(int, input().split()))

for x in B:
    if x in A:
        print(1)
    else:
        print(0)