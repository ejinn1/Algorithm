function solution(elements) {
    
    let tmp = new Set()
    let len = elements.length
    for(let cnt=1 ; cnt<=len ; cnt++){
        for(let i=0 ; i<len ; i++){
            let t = []
            let sum = 0
            for(let j=0 ; j<cnt ; j++){
                sum += elements[(i + j) % len]
            }
            tmp.add(sum)
        }
    }
    
    return tmp.size
}