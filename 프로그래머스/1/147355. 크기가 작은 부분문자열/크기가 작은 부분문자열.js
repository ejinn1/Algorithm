function solution(t, p) {
    const len = p.length
    let result = 0
    for(let i=0 ; i<=t.length - len ; i++){
        const num = parseInt(t.slice(i, i+len))
        
        if(parseInt(p) >= num) result++
    }
    
    return result
}