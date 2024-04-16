function solution(str) {
    const tmp = []
    
    
    const result = str.split('').map((s) => {
        if(tmp.includes(s)){
            tmp.push(s)
            const r = tmp.indexOf(s)
            tmp[r] = -1
            return tmp.lastIndexOf(s) - r
        } else {
            tmp.push(s)
            return -1
        }
    })
    
    return result
}