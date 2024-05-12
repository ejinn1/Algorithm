function solution(n) {    
    if(n === 1) return 1
    
    let a = 1
    let b = 2
    for(let i=3 ; i<=n ; i++){
        let tmp = (a + b) % 1234567
        a = b
        b = tmp
    }
    
    return b
}