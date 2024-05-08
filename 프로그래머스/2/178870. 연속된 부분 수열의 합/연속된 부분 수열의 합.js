function solution(sequence, k) {
    let start = 0
    let end = 0
    let sum = sequence[0]
    let bestRange = [0, sequence.length-1]
    let minLength = Infinity
    
    while(start < sequence.length){
        if(sum < k){
            end++
            if(end < sequence.length){
                sum += sequence[end]
            } else{
                break
            }
        } else if (sum > k){
            sum -= sequence[start]
            start++
        } else {
            let curLength = end - start + 1
            if(minLength > curLength){
                minLength = curLength
                bestRange = [start, end]
            }
            sum -= sequence[start]
            start++
        }
    }
    
    return bestRange
}