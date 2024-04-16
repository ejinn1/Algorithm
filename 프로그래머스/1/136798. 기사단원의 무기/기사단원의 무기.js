function solution(number, limit, power) {
    let sum = 0
    
    const count = Array.from({length: number+1}).fill(0)
    
    for(let i=1 ; i<=number ; i++){
        for(let j=i ; j<=number ; j+=i){
            count[j]++
        }
    }
    
    count.shift()
    
    count.forEach((c) => {
        if(c <= limit){
            sum += c
        } else {
            sum += power
        }
    })
    
    return sum
}