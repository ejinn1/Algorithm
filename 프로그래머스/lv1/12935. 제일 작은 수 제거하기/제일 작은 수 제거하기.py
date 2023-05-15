def solution(arr):
    min = arr[0]
    for i in arr:
        if i <= min:
            min = i
    arr.remove(min)
    if arr == []:
        arr = [-1]
    return arr