function solution(today, terms, privacies) {
    const result = []
    
    terms = terms.reduce((acc, term) => {
        const [key, value] = term.split(' ')
        acc[key] = value
        
        return acc
    }, {})
    
    privacies = privacies.map((p) => {
        let [date, private] = p.split(' ')
        return [date.split('.').map((i) => parseInt(i)), private]
    })
    
    privacies.forEach((p) => {
        let date = p[0]
        let priv = p[1]
        
        date[1] += Number(terms[priv])

        if(date[1] > 12){
            date[1] -= 12
            date[0]++
        }
    })
    
    today = today.split('.').map((t) => parseInt(t))
    
    privacies.forEach((p, i) => {
        
        const a = new Date(...today)
        const b = new Date(...p[0])
        
        if(a >= b){
            result.push(i+1)
        }
    })
    
    return result
    
}