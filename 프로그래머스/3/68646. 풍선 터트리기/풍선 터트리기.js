function solution(a) {
    const n = a.length
    let cnt = n
    
    const leftMin = Array(n).fill(Infinity)
    const rightMin = Array(n).fill(Infinity)
    
    leftMin[0] = a[0]
    for(let i=1 ; i<n ; i++){
        leftMin[i] = Math.min(leftMin[i-1], a[i])
    }

    rightMin[n-1] = a[n-1]
    for(let i=n-2 ; i>=0 ; i--){
        rightMin[i] = Math.min(rightMin[i+1], a[i])
    }
    
    for(let i=1 ; i<n-1 ; i++){
        let cur = a[i]
        
        if(leftMin[i] < cur && rightMin[i] < cur){
            cnt--
        }
    }
    
    return cnt
    
}