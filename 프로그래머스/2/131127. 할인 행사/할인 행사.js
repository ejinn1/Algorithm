function solution(want, number, discount) {
    
    let res = 0
    let i = 0
    while(i < discount.length){
        const products = discount.slice(i,i+10)
        const countMap = new Map()
        products.forEach((p) => {
            if(countMap.has(p)){
                countMap.set(p, countMap.get(p) + 1)
            } else {
                countMap.set(p, 1)
            }
        })
        
        let day = false
        for(let j=0 ; j<want.length ; j++){
            if(number[j] > countMap.get(want[j]) || !countMap.has(want[j])){
                day = false
                break
            }
            day = true
        }
        
        if(day){
            res++
        }
        i++
        
    }
    
    return res
}