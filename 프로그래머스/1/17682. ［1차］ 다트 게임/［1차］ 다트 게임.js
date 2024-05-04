function solution(dartResult) {
    // S 1, D 2, T 3
    // * 해당, 전 2배, # 해당점수 -
    
    const score = []
    let j = -1
    
    for(let i=0 ; i<dartResult.length ; i++){
        const d = dartResult[i]
        
        if(d >= '0' && d <= '9'){
            j++
            if(dartResult[i+1] >= '0' && dartResult[i+1] <= '9'){
                i++
                score[j] = 10
            } else {
                score[j] = Number(d)
            }
        } else if (d === "S" || d === "D" || d === "T"){
            if(d === "D"){
                score[j] = score[j]**2
            } else if(d === "T"){
                score[j] = score[j]**3
            }
        } else if (d === "*" || d === "#"){
            if(d === "*"){
                score[j] *= 2
                if(j>0){
                    score[j-1] *= 2
                }
            } else if(d === "#"){
                score[j] *= -1
            }
        }
        
        console.log(d, j, score)
    }
    
    console.log("결과")
    
    const result = score.reduce((acc, cur, idx) => {
        return acc + cur
    },0)
    
    return result
    
}