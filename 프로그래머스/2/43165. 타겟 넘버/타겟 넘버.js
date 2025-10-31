function solution(numbers, target) {
    
    let result = 0
    function dfs(i, sum){
        if(i === numbers.length && sum === target){
            result++
            return
        } else if(i === numbers.length && sum !== target){
            return
        }
        
        dfs(i+1, sum + numbers[i])
        dfs(i+1, sum - numbers[i])
    }
    
    dfs(0, 0)
    
    return result
    
}