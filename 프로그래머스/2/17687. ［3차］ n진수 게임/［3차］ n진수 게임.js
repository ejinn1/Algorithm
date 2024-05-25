function solution(n, t, m, p) {
    
    let res = []
    let num = 0
    let str = ""
    
    while(str.length < m * t){
        str += num.toString(n).toUpperCase()
        num++
    }
    
    for(let i=p-1 ; i<m*t ; i+=m){
        if(res.length < t){
            res.push(str[i])
        } else break
    }
    
    return res.join('')
}