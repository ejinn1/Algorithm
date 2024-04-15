function solution(t, p) {
    let result = 0
    const len = p.split('').length
    const str = t.split('')
    
    for(let i=0 ; i<str.length-len+1 ; i++){
        if(parseInt(str.slice(i,i+len).join('')) <= parseInt(p)){
            result++
        }
    }
    
    return result
    
}