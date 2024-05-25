function solution(n, k) {
    let x = n.toString(k)
    x = [...x].reverse()
    let box = []
    let p = []
    while(x.length > 0){
        let y = x.pop()
        if(y === "0"){
            let num = p.join('')
            if(num.length > 0 && num !== '1'){
                box.push(num)
            }
            p = []
        } else {
            p.push(y)
        }
    }
    
    if(p.length > 0){
        let num = p.join('')
        if(num.length > 0 && num !== '1'){
            box.push(num)
        }
    }
    
    function isPrime(n){
        for(let i=2 ; i*i<=n ; i++){
            if(n % i === 0) return false
        }
        return true
    }
    
    let res = 0
    box.forEach((num) => {
        if(isPrime(num)) res++
    })
    return res
}