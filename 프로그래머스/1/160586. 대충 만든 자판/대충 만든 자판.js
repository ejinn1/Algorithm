function solution(keymap, targets) {
    
    let sum = 0
    let result = targets.map((tar) => {
        sum = 0    
        tar.split('').forEach((t) => {
            let min = Infinity
            keymap.forEach((key) => {
                let push = key.indexOf(t)
                
                if(push > -1){
                    min = Math.min(min, push+1)
                }
            })
            sum += min
        })
        return sum
    })
    
    result = result.map((r) => {
        if(r === Infinity){
            return -1
        }
        return r
    })
    
    return result
    
}