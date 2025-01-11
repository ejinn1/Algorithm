function solution(array) {
    const arrayMap = new Map()
    
    for(const a of array){
        arrayMap.set(a, (arrayMap.get(a) || 0) + 1)
    }
    
    const arr = [...arrayMap].sort((a, b) => b[1] - a[1])
    if(arr.length > 1 && arr[0][1] === arr[1][1]){
        return -1
    }
    
    return arr[0][0]
}