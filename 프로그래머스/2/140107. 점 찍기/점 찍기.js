function solution(k, d) {
    
    let result = 0
    for(let i=0 ; i<=d ; i+=k){
        const y = parseInt(Math.sqrt(d*d - i*i))
        result += parseInt(y / k + 1)
    }
    
    return result
}