function solution(people, limit) {
    people = people.sort((a, b) => a - b)
    
    let result = 0
    let i=0
    let j=people.length-1
    while(i <= j){
        if(people[i] + people[j] <= limit){
            result++
            i++
            j--
        } else {
            result++
            j--
        }
    }
    
    return result
    
}