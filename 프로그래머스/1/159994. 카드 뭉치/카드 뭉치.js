function solution(cards1, cards2, goal) {
    let result = true
    
    goal.forEach((g) => {
        let one = cards1.shift()  
        let two = cards2.shift()
      
        if(one === g){
            cards2.unshift(two)
        } else if(two === g){
            cards1.unshift(one)
        } else {
            result = false
        }
    })
    
    return result ? "Yes" : "No"
}