function solution(A, B) {
    let result = 0
    
    A.sort((a, b) => a - b)
    B.sort((a, b) => a - b)
    
    console.log(A)
    console.log(B)
    
    let i = 0
    let j = 0
    while(i < A.length && j < B.length){
        if(B[j] > A[i]){
            i++
            j++
            result++
        } else {
            j++
        }
    }

    
    return result
}