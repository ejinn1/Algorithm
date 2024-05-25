function solution(n) {

    let res = []
    while(n > 0){
        let k = n % 3
        if(k === 0){
            res.push("4")
            n -= 3
        } else if(k === 1){
            res.push("1")
        } else if(k === 2){
            res.push("2")
        }
        n = Math.floor(n / 3)
    }
    
    return res.reverse().join('')
    
}