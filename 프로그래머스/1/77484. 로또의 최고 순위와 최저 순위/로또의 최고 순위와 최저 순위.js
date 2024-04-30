function solution(lottos, win_nums) {
    lottos.sort((a,b) => a-b)
    win_nums.sort((a,b) => a-b)
    
    const base = win_nums.filter(x => lottos.includes(x)).length
    const zero = lottos.filter(x => x === 0).length
    const result = [7-base-zero, 7-base]
    
    if(result[0] === 7){
        result[0] = 6
        result[1] = 6
    }
    if(result[1] === 7){
        result[1] = 6
    }
    
    return result
}