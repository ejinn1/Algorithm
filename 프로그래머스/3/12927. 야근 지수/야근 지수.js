function solution(n, works) {
    works.sort((a, b) => b - a)
    
    while(n > 0){
        const max = Math.max(...works)
        
        if(max === 0) break
        
        works = works.map((work) => {
            if(work === max && n > 0){
                work--
                n--
            }
            return work
        })
    }
    
    return works.reduce((acc, cur) => acc+=cur*cur, 0)
}