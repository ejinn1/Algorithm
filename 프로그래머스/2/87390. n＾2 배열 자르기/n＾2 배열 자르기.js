function solution(n, left, right) {
    let res = []
    for(let i=left ; i<=right ; i++){
        let q = Math.floor(i / n)
        let r = Math.floor(i % n)
        let tmp = r+1
        if(q > r) tmp = q+1
        res.push(tmp)
    }
    
    return res
}