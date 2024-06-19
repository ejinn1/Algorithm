function solution(s) {
    let res = new Set
    let tmp = s.slice(2, s.length-2).split('},{')
    tmp = tmp.map((t) => t.split(','))
    tmp = tmp.sort((a, b) => a.length - b.length)
    
    for(let i=0 ; i<tmp.length ; i++){
        for(let num of tmp[i]){
            res.add(parseInt(num))
        }
    }
    return [...res]
}