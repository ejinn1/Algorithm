function solution(targets) {
    targets = targets.sort((a, b) => b[0] - a[0])
    
    let result = 0
    let shoot = Infinity
    targets.forEach((tar) => {
        if(tar[1] < shoot){
            result++
            shoot = tar[0] + 0.5
        }
    })
    
    return result
}