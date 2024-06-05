function solution(survey, choices) {
    let MBTI = {}
    const types = ['RT', 'CF', 'JM', 'AN']
    
    types.forEach((type) => {
        type.split('').forEach((k) => MBTI[k] = 0)
    })
    
    for(let i=0 ; i<choices.length ; i++){
        const [a, b] = survey[i].split('')
        const n = choices[i]
        if(n < 4){
            MBTI[a] += 4-n
        } else if(n > 4){
            MBTI[b] += n-4
        }
    }
    
    let res = ""
    types.forEach((type) => {
        const [a, b] = type.split('')
        if(MBTI[a] > MBTI[b]){
            res += a
        } else if(MBTI[a] < MBTI[b]){
            res += b
        } else {
            a > b ? res += b : res += a
        }
    })

    return res
}