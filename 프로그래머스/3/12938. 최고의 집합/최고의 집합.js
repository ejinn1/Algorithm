function solution(n, s) {
    const k = Math.floor(s/n)
    
    if(k === 0){
        return [-1]
    }
    
    let res = s - k*n
    const result = Array(n-res).fill(k)
    for(let i=0 ; i< res ; i++){
        result.push(k+1)
    }
    
    return result
    
}