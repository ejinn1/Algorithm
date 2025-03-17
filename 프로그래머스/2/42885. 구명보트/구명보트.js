function solution(people, limit) {
    people.sort((a, b) => a - b)
    let cnt = 0
    let res = 0
    
    let i=0
    let j=people.length-1
    
    while(i <= j){
        if(people[i] + people[j] <= limit){
            // people = people.slice(i+1, j)
            i++
            j--
            cnt++
        } else {
            res++
            j--
        }
    }
    
    return cnt + res
    
}