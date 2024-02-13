function solution(array, commands) {
    const result = []
    
    for(com of commands){
        const [i, j, k] = com
        const newArr = array.slice(i - 1, j)
        newArr.sort((a, b) => a - b)
        
        result.push(newArr[k-1])
    }
    
    return result
}