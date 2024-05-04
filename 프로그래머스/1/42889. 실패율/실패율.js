function solution(N, stages) {
    const obj = {}
    
    Array.from({length:N}).forEach((_,i) => {
        const n = i+1
        let p = 0
        let f = 0
        stages.forEach((s) => {
            if(s > n){
                p++
            } else if(s === n){
                p++
                f++
            }
        })
        
        const r = f/p === Infinity ? f !== 0 ? 1 : 0 : f/p
        obj[n] = r
    })
    
    const result = Object.entries(obj).sort(([, a], [, b]) => b-a)
    
    return result.map((r) => Number(r[0]))
}