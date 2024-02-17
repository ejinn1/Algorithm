function solution(answers) {
    const patterns = [
        [1,2,3,4,5],
        [2,1,2,3,2,4,2,5],
        [3,3,1,1,2,2,4,4,5,5]
    ]
    let scores = [0,0,0]
    
    answers.forEach((answer, i) => {
        patterns.forEach((pattern, j) => {
            if(answer === pattern[i % pattern.length]){
                scores[j]++
            }
        })
    })
    
    const maxScore = Math.max(...scores)
    const result = scores.reduce((acc, score, i) => {
        if(score === maxScore){
            acc.push(i+1)
        }
        return acc
    },[])
    
    return result
    
}