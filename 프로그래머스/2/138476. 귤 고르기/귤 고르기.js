function solution(k, tangerine) {
    const countMap = new Map()
    
    tangerine.reduce((acc, val) => {
       if(countMap.has(val)){
           countMap.set(val, countMap.get(val) + 1)
       } else{
           countMap.set(val, 1)
       }
    },{})
    const arr = Array.from(countMap).sort((a, b) => b[1] - a[1])
    console.log(arr)
    
    let result = 0
    for(let i=0 ; i<arr.length ; i++){
        result++
        if(arr[i][1] < k ){
           k -= arr[i][1]
        } else {
            break
        }
    }
    
    return result
    
}