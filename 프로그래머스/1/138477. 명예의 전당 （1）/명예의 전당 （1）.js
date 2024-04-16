function solution(k, score) {
    
    const tmp = []
    
    const result = score.map((s) => {
        tmp.push(s) 
        tmp.sort((a,b) => b-a)
        
        if(tmp.length < k){
            return tmp[tmp.length-1]
        }
        
        return tmp[k-1]
    })
    
    return result
}