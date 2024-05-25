function solution(msg) {
    let dic = {}
    let cnt = 1
    // A -> 65
    for(let i='A'.charCodeAt() ; i<='Z'.charCodeAt() ; i++){
        dic[String.fromCharCode(i)] = cnt++
    }
    
    let res = []
    msg = [...msg].reverse()
    let cur = msg.pop()
    let str = cur
    
    while (msg.length > 0) {
        cur = msg.pop()
        if (dic[str + cur]) {
            str += cur
        } else {
            res.push(dic[str])
            dic[str + cur] = cnt++
            str = cur
        }
    }
    if(str.length > 0){
        res.push(dic[str])
    }
    
    return res
    
}