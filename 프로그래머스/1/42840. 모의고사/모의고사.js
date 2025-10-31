function solution(answers) {
    const patterns = [
        [1,2,3,4,5],
        [2,1,2,3,2,4,2,5],
        [3,3,1,1,2,2,4,4,5,5]
    ]
    
    let cnts = [0,0,0]
    for(let i=0 ; i<answers.length ; i++){
        const ans = answers[i]
        for(let j=0 ; j<patterns.length ; j++){
            const p = patterns[j][i % patterns[j].length]
            if(p === ans){
                cnts[j]++
            }
        }
    }
    
    const max = Math.max(...cnts)
    const result = []
    for(let i=0 ; i<3 ; i++){
        if(cnts[i] === max) result.push(i+1)
    }
    
    return result.sort((a, b) => a - b)
}